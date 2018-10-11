/**
 * Copyright (c) 2010-2018 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.miio.internal;

/**
 * The {@link MiIoCommand} contains all known commands for the Xiaomi vacuum & various Mi IO commands
 *
 * @author Marcel Verpaalen - Initial contribution
 */
public enum MiIoCommand {

    MIIO_INFO("miIO.info"),
    MIIO_WIFI("miIO.wifi_assoc_state"),
    MIIO_ROUTERCONFIG("miIO.miIO.config_router"),

    // Basic device commands
    GET_PROPERTY("get_prop"),
    SET_MODE_BASIC("set_mode"),
    SET_POWER("set_power"),
    SET_BRIGHT("set_bright"),

    // gateway commands
    GET_DEVICE_PROPERTY("get_device_prop"),

    GET_RGB("get_rgb"),
    SET_RGB("set_rgb"),

    GET_NIGHT_LIGHT_RGB("get_night_light_rgb"),
    SET_NIGHT_LIGHT_RGB("set_night_light_rgb"),

    GET_ARM_WAIT_TIME("get_arm_wait_time"),
    SET_ARMING("set_arming"),


    SET_ALARMING_VOLUME("set_alarming_volume"),
    SET_DOORBELL_VOLUME("set_doorbell_volume"),
    SET_GATEWAY_VOLUME("set_gateway_volume"),
    SET_FM_VOLUME("set_fm_volume"),

    GET_ALARMING_VOLUME("get_alarming_volume"),
    GET_DOORBELL_VOLUME("get_doorbell_volume"),
    GET_GATEWAY_VOLUME("get_gateway_volume"),

    PLAY_SPECIFY_FM("play_specify_fm"),
    PLAY_FM("play_fm"),
    GET_PROPERTY_FM("get_prop_fm"),
    GET_FM_CHANNELS("get_channels"),

    START_ZIGBEE_JOIN("start_zigbee_join"),

    // vacuum commands
    START_VACUUM("app_start"),
    STOP_VACUUM("app_stop"),
    START_SPOT("app_spot"),
    PAUSE("app_pause"),
    CHARGE("app_charge"),
    START_ZONE("app_zoned_clean"),
    FIND_ME("find_me"),

    CONSUMABLES_GET("get_consumable"),
    CONSUMABLES_RESET("reset_consumable"),
    CLEAN_SUMMARY_GET("get_clean_summary"),
    CLEAN_RECORD_GET("get_clean_record"),
    CLEAN_RECORD_MAP_GET("get_clean_record_map"),

    GET_MAP("get_map_v1"),
    GET_STATUS("get_status"),
    GET_SERIAL_NUMBER("get_serial_number"),

    DND_GET("get_dnd_timer"),
    DND_SET("set_dnd_timer"),
    DND_CLOSE("close_dnd_timer"),

    TIMER_SET("set_timer"),
    TIMER_UPDATE("upd_timer"),
    TIMER_GET("get_timer"),
    TIMER_DEL("del_timer"),

    SOUND_INSTALL("dnld_install_sound"),
    SOUND_GET_CURRENT("get_current_sound"),
    LOG_UPLOAD_GET("get_log_upload_status"),
    LOG_UPLOAD_ENABLE("enable_log_upload"),

    SET_MODE("set_custom_mode"),
    GET_MODE("get_custom_mode"),

    TIMERZONE_SET("set_timezone"),
    TIMERZONE_GET("get_timezone"),
    GATEWAY("gateway"),

    REMOTE_START("app_rc_start"),
    REMOTE_END("app_rc_end"),
    REMOTE_MOVE("app_rc_move"),

    UNKNOWN(""), ;

    private final String command;

    private MiIoCommand(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    public static MiIoCommand getCommand(String commandString) {
        for (MiIoCommand mioCmd : MiIoCommand.values()) {
            if (mioCmd.getCommand().equals(commandString)) {
                return mioCmd;
            }
        }
        return UNKNOWN;
    }

}
