package org.openhab.binding.miio.handler;

import com.google.common.base.Strings;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.smarthome.core.library.types.DecimalType;
import org.eclipse.smarthome.core.library.types.HSBType;
import org.eclipse.smarthome.core.library.types.OnOffType;
import org.eclipse.smarthome.core.library.types.PercentType;
import org.eclipse.smarthome.core.thing.ChannelUID;
import org.eclipse.smarthome.core.thing.Thing;
import org.eclipse.smarthome.core.types.Command;
import org.eclipse.smarthome.core.types.RefreshType;
import org.openhab.binding.miio.MiIoBindingConstants;
import org.openhab.binding.miio.internal.MiIoCommand;
import org.openhab.binding.miio.internal.MiIoSendCommand;
import org.openhab.binding.miio.internal.gateway.service.CommunicationPort;
import org.openhab.binding.miio.internal.gateway.service.GatewayService;
import org.openhab.binding.miio.internal.gateway.vo.MiIoLedColor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by wfred on 05.10.18.
 */
public class MiIoGatewayHandler extends MiIoAbstractHandler {

    private final Logger logger = LoggerFactory.getLogger(MiIoGatewayHandler.class);

    private GatewayService gatewayService;

    private Long color = null;
    private Integer brightness = null;

    private Long nightColor = null;
    private Integer nightBrightness = null;


    @Override
    public void initialize() {
        super.initialize();

        CommunicationPort communicationPort = MiIoGatewayHandler.this::sendCommand;
        gatewayService = new GatewayService(communicationPort);
    }

    @NonNullByDefault
    public MiIoGatewayHandler(Thing thing) {
        super(thing);
    }

    @Override
    public void handleCommand(ChannelUID channelUID, Command command) {
        logger.debug("Executing command: channelId: {}, groupId: {}, channelThingId: {}, COMMAND: {} ({})",
                channelUID.getId(), channelUID.getGroupId(), channelUID.getThingUID().getAsString(),
                command.toFullString(), command.getClass().getCanonicalName());

        if (command == RefreshType.REFRESH && gatewayService == null) {
            return;
        }

        switch (channelUID.getId().toLowerCase()) {
            case MiIoBindingConstants.CHANNEL_GATEWAY_TEST_ACTION:
                if (command == RefreshType.REFRESH) {

                } else {
                    logger.debug("Executing test action: " + command.toFullString());

    //                if (command.toFullString().equalsIgnoreCase("on")) {
    //                    brightness = 100;
    //                } else {
    //                    brightness = 0;
    //                }
    //
    //                if (color != null) {
    //                    gatewayService.setRgbColor(MiIoLedColor.fromRgbAndBrightness(color).setBrightnessPercent(brightness));
    //                }

                    sendCommand(MiIoCommand.GET_DEVICE_PROPERTY, "");

                }
                break;

            case MiIoBindingConstants.CHANNEL_GATEWAY_VOLUME_ALARMING:
                if (command == RefreshType.REFRESH) {
                    updateDataAlarmingVolume();
                } else {
                    String parsedValue = command.toFullString().replaceAll("[\\D]", "");
                    if (!Strings.isNullOrEmpty(parsedValue)) {
                        int volume = Integer.valueOf(parsedValue);
                        gatewayService.setAlarmingVolume(volume);
                    }
                }
                break;
            case MiIoBindingConstants.CHANNEL_GATEWAY_VOLUME_GATEWAY:
                if (command == RefreshType.REFRESH) {
                    updateDataGatewayVolume();
                } else {
                    String parsedValue = command.toFullString().replaceAll("[\\D]", "");
                    if (!Strings.isNullOrEmpty(parsedValue)) {
                        int volume = Integer.valueOf(parsedValue);
                        gatewayService.setGatewayVolume(volume);
                    }
                }
                break;
            case MiIoBindingConstants.CHANNEL_GATEWAY_VOLUME_DOORBELL:
                if (command == RefreshType.REFRESH) {
                    updateDataGatewayVolume();
                } else {
                    String parsedValue = command.toFullString().replaceAll("[\\D]", "");
                    if (!Strings.isNullOrEmpty(parsedValue)) {
                        int volume = Integer.valueOf(parsedValue);
                        gatewayService.setDoorbellVolume(volume);
                    }
                }
                break;
            case MiIoBindingConstants.CHANNEL_GATEWAY_VOLUME_FM:
                if (command == RefreshType.REFRESH) {
                    updateDataRadioFm();
                } else {
                    String parsedValue = command.toFullString().replaceAll("[\\D]", "");
                    if (!Strings.isNullOrEmpty(parsedValue)) {
                        int volume = Integer.valueOf(parsedValue);
                        gatewayService.setFmVolume(volume);
                    }
                }
                break;
            case MiIoBindingConstants.CHANNEL_GATEWAY_NIGHT_LIGHT_LED_BRIGHTNESS:
//                if (command == RefreshType.REFRESH) {
//                    updateDataNightLightRgb();
//                } else {
//                    String parsedValue = command.toFullString().replaceAll("[\\D]", "");
//                    if (!Strings.isNullOrEmpty(parsedValue)) {
//                        nightBrightness = Integer.valueOf(parsedValue);
//                        gatewayService.setNightLightRgb(MiIoLedColor.fromRgbAndBrightness(color).setBrightnessPercent(brightness));
//                    }
//                }
//                break;

            case MiIoBindingConstants.CHANNEL_GATEWAY_LED_BRIGHTNESS:
//                if (command == RefreshType.REFRESH) {
//                    updateDataRgb();
//                } else if (command instanceof DecimalType) {
//                    String parsedValue = command.toFullString().replaceAll("[\\D]", "");
//                    if (!Strings.isNullOrEmpty(parsedValue)) {
//                        brightness = Integer.valueOf(parsedValue);
//                        gatewayService.setRgbColor(MiIoLedColor.fromRgbAndBrightness(color).setBrightnessPercent(brightness));
//                        updateState(MiIoBindingConstants.CHANNEL_GATEWAY_LED_BRIGHTNESS,
//                                new PercentType(brightness));
//                    }
//                } else {
//                    logger.error("Unknown command type: " + command.getClass().getCanonicalName());
//                }

                break;
            case MiIoBindingConstants.CHANNEL_GATEWAY_LED_COLOR:
                logger.debug("Setting color in leds");

                if (command == RefreshType.REFRESH) {
                    updateDataRgb();
                } else if (command instanceof OnOffType) {
                    if (command.toFullString().equalsIgnoreCase("on")) {
                        gatewayService.setRgbColor(MiIoLedColor.fromRgbAndBrightness(color).setBrightnessPercent(brightness));
                    } else {
                        gatewayService.setRgbColor(MiIoLedColor.fromRgbAndBrightness(color).setBrightnessPercent(0));
                    }
                } else if (command instanceof HSBType) {
                    HSBType hsb = (HSBType) command;
                    MiIoLedColor ledColor = MiIoLedColor.fromHsb(
                            hsb.getHue().intValue(),
                            hsb.getSaturation().intValue(),
                            hsb.getBrightness().intValue());
                    color = ledColor.getAllInOne();
                    brightness = ledColor.getBrightnessPercent();
                    gatewayService.setRgbColor(ledColor);
                } else {
                    logger.error("Unknown command type: " + command.getClass().getCanonicalName());
                }

                break;
            case MiIoBindingConstants.CHANNEL_GATEWAY_NIGHT_LIGHT_LED_COLOR:
                logger.debug("Setting color in leds");

                if (command == RefreshType.REFRESH) {
                    updateDataNightLightRgb();;
                } else if (command instanceof OnOffType) {
                    if (command.toFullString().equalsIgnoreCase("on")) {
                        gatewayService.setNightLightRgb(MiIoLedColor.fromRgbAndBrightness(nightColor).setBrightnessPercent(nightBrightness));
                    } else {
                        gatewayService.setNightLightRgb(MiIoLedColor.fromRgbAndBrightness(nightColor).setBrightnessPercent(0));
                    }
                } else if (command instanceof HSBType) {
                    HSBType hsb = (HSBType) command;
                    MiIoLedColor ledColor = MiIoLedColor.fromHsb(
                            hsb.getHue().intValue(),
                            hsb.getSaturation().intValue(),
                            hsb.getBrightness().intValue());
                    nightColor = ledColor.getAllInOne();
                    nightBrightness = ledColor.getBrightnessPercent();
                    gatewayService.setNightLightRgb(ledColor);
                } else {
                    logger.error("Unknown command type: " + command.getClass().getCanonicalName());
                }

                break;
        }
    }

    @Override
    protected synchronized void updateData() {
        logger.debug("Periodic update for '{}' ({})", getThing().getUID().toString(), getThing().getThingTypeUID());
        try {
            if (!hasConnection() || skipUpdate()) {
                return;
            }

            updateDataBasicInfo();

            updateDataRadioFm();
            updateDataFmLowRate();

            updateDataAlarmingVolume();
            updateDataDoorbellVolume();
            updateDataGatewayVolume();

            updateDataArmWaitTime();
        } catch (Exception e) {
            logger.debug("Error while updating '{}'", getThing().getUID().toString(), e);
        }
    }



    private void updateDataArmWaitTime() {
        gatewayService.getArmWaitTime(time -> {
            updateState(MiIoBindingConstants.CHANNEL_GATEWAY_ALARM_ARM_WAIT_TIME,
                    new DecimalType(time));
        });
    }

    private void updateDataGatewayVolume() {
        gatewayService.getGatewayVolume(volume -> {
            logger.debug("Received gateway volume: " + volume);
            updateState(MiIoBindingConstants.CHANNEL_GATEWAY_VOLUME_GATEWAY,
                    new PercentType(volume.intValue()));
        });
    }

    private void updateDataDoorbellVolume() {
        gatewayService.getDoorbellVolume(volume -> {
            logger.debug("Received doorbell volume: " + volume);
            updateState(MiIoBindingConstants.CHANNEL_GATEWAY_VOLUME_DOORBELL,
                    new PercentType(volume.intValue()));
        });
    }

    private void updateDataAlarmingVolume() {
        gatewayService.getAlarmingVolume(volume -> {
            logger.debug("Received alarm volume: " + volume);
            updateState(MiIoBindingConstants.CHANNEL_GATEWAY_VOLUME_ALARMING,
                    new PercentType(volume.intValue()));
            updateState(MiIoBindingConstants.CHANNEL_GATEWAY_ALARM_VOLUME,
                    new PercentType(volume.intValue()));
                });
    }

    private void updateDataBasicInfo() {
        gatewayService.getBasicInfo(basicInfo -> {
            logger.debug("Received basic information from gatewaya: RGB: {} NIGHT_LIGHT: {} ALARM: {}",
                    basicInfo.getColor().getAllInOne(),
                    basicInfo.getNightLight().getAllInOne(),
                    basicInfo.isAlarmArmed());

            color = basicInfo.getColor().getAllInOne();
            brightness = basicInfo.getColor().getBrightnessPercent();

            nightColor = basicInfo.getNightLight().getAllInOne();
            nightBrightness = basicInfo.getNightLight().getBrightnessPercent();

            updateState(MiIoBindingConstants.CHANNEL_GATEWAY_LED_BRIGHTNESS,
                    new PercentType(basicInfo.getColor().getBrightnessPercent()));
            updateState(MiIoBindingConstants.CHANNEL_GATEWAY_LED_COLOR,
                    new HSBType(basicInfo.getColor().toHsbString()));

            updateState(MiIoBindingConstants.CHANNEL_GATEWAY_NIGHT_LIGHT_LED_COLOR,
                    new HSBType(basicInfo.getNightLight().toHsbString()));
            updateState(MiIoBindingConstants.CHANNEL_GATEWAY_NIGHT_LIGHT_LED_BRIGHTNESS,
                    new PercentType(basicInfo.getNightLight().getBrightnessPercent()));

            updateState(MiIoBindingConstants.CHANNEL_GATEWAY_ILLUMINATION,
                    new DecimalType(basicInfo.getIllumination()));
        }) ;
    }

    private void updateDataNightLightRgb() {
        gatewayService.getNightLightRgb(color -> {
            updateState(MiIoBindingConstants.CHANNEL_GATEWAY_NIGHT_LIGHT_LED_COLOR,
                    new HSBType(color.toHsbString()));
            updateState(MiIoBindingConstants.CHANNEL_GATEWAY_NIGHT_LIGHT_LED_BRIGHTNESS,
                    new PercentType(color.getBrightnessPercent()));
        });
    }

    private void updateDataRgb() {
        if (gatewayService != null) {
            gatewayService.getRgbColor(color -> {
                this.color = color.getAllInOne();
                brightness = color.getBrightnessPercent();

                updateState(MiIoBindingConstants.CHANNEL_GATEWAY_LED_BRIGHTNESS,
                        new PercentType(color.getBrightnessPercent()));
                updateState(MiIoBindingConstants.CHANNEL_GATEWAY_LED_COLOR,
                        new HSBType(color.toHsbString()));

            });
        }
    }

    private void updateDataRadioFm() {
        gatewayService.getPropertiesFm(fm -> {
            logger.debug("Received fm volume: " + fm.getCurrentVolume());
            updateState(MiIoBindingConstants.CHANNEL_GATEWAY_VOLUME_FM,
                    new PercentType(fm.getCurrentVolume().intValue()));

            //todo: add missing channels in xmls
        });

    }

    private void updateDataFmLowRate() {
        gatewayService.getFmLowRate(fm -> {
            //todo: add missing channels in xmls
        });
    }

    @Override
    public void onMessageReceived(MiIoSendCommand response) {
        super.onMessageReceived(response);
        if (response.isError()) {
            return;
        }

        if (gatewayService.onMessageReceived(response)) {
            return;
        }

        try {
            switch (response.getCommand()) {
                case MIIO_INFO:
                    break;
                case GET_PROPERTY:
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            logger.debug("Error while handing message {}", response.getResponse(), e);
        }
    }

}
