# Xiaomi Robot Vacuum Binding

This binding is used to control Xiaomi products implementing the Mi IO protocol. 
This is a set of wifi devices from Xiaomi that are part of the Mi Ecosystem which is branded as MiJia.

![MIIO logo](doc/miio.png)

## Supported Things

The following things are available:

| Thing Type | Description |
|--------|---------| 
| miio:generic | Generic type for discovered devices. Once the token is available and the device model is determined, this Thing Type will automatically change to the appropriate Thing Type |
| miio:vacuum | For Xiaomi Robot Vacuum products|
| miio:basic | For several basic devices like yeelights, airpurifiers. Channels and commands are determined by database configuration |
| miio:unsupported | For experimenting with other devices which use the Mi IO protocol)

## Mi IO Devices

| Device | Thing Type | Device Model  | Supported | Remark |
| ----------- | --------- | ---------- | ------ | -----------| 
| AUX Air Conditioner | miio:unsupported | aux.aircondition.v1 | No |  |
| Idelan Air Conditioner | miio:unsupported | idelan.aircondition.v1 | No |  |
| Midea Air Conditioner v2 | miio:unsupported | midea.aircondition.v1 | No |  |
| Midea Air Conditioner v2 | miio:unsupported | midea.aircondition.v2 | No |  |
| Midea Air Conditioner xa1 | miio:unsupported | midea.aircondition.xa1 | No |  |
| Mi Air Monitor v1 | miio:basic | zhimi.airmonitor.v1 | Yes |  |
| Mi Air Humidifier | miio:basic | zhimi.humidifier.v1 | Yes |  |
| Mi Air Humidifier | miio:basic | zhimi.humidifier.ca1 | Yes |  |
| Mi Air Purifier v1 | miio:basic | zhimi.airpurifier.v1 | Yes |  |
| Mi Air Purifier v2 | miio:basic | zhimi.airpurifier.v2 | Yes |  |
| Mi Air Purifier v3 | miio:basic | zhimi.airpurifier.v3 | Yes |  |
| Mi Air Purifier Pro v6 | miio:basic | zhimi.airpurifier.v6 | Yes |  |
| Mi Air Purifier 2 (mini) | miio:basic | zhimi.airpurifier.m1 | Yes |  |
| Mi Air Purifier (mini) | miio:basic | zhimi.airpurifier.m2 | Yes |  |
| Mi Air Purifier MS1 | miio:basic | zhimi.airpurifier.ma1 | Yes |  |
| Mi Air Purifier MS2 | miio:basic | zhimi.airpurifier.ma2 | Yes |  |
| Mi Air Purifier Super | miio:basic | zhimi.airpurifier.sa1 | Yes |  |
| Mi Air Purifier Super 2 | miio:basic | zhimi.airpurifier.sa2 | Yes |  |
| Mi Remote v2 | miio:unsupported | chuangmi.ir.v2 | No |  |
| MiJia Rice Cooker | miio:unsupported | chunmi.cooker.normal1 | No |  |
| MiJia Rice Cooker | miio:unsupported | chunmi.cooker.normal2 | No |  |
| MiJia Rice Cooker | miio:unsupported | hunmi.cooker.normal3 | No |  |
| MiJia Rice Cooker | miio:unsupported | chunmi.cooker.normal4 | No |  |
| MiJia Heating Pressure Rice Cooker | miio:unsupported | chunmi.cooker.press1 | No |  |
| MiJia Heating Pressure Rice Cooker | miio:unsupported | chunmi.cooker.press2 | No |  |
| Mi Smart Fan | miio:basic | zhimi.fan.v1 | Yes |  |
| Mi Smart Fan | miio:basic | zhimi.fan.v2 | Yes |  |
| Mi Smart Pedestal Fan | miio:basic | zhimi.fan.v3 | Yes |  |
| Mi Smart Home Gateway v1 | miio:unsupported | lumi.gateway.v1 | No |  |
| Mi Smart Home Gateway v2 | miio:unsupported | lumi.gateway.v2 | No |  |
| Mi Smart Home Gateway v3 | miio:unsupported | lumi.gateway.v3 | No |  |
| Mi Humdifier | miio:basic | zhimi.humidifier.v1 | Yes |  |
| Light Control (Wall Switch) | miio:unsupported | lumi.ctrl_neutral1.v1 | No |  |
| Light Control (Wall Switch) | miio:unsupported | lumi.ctrl_neutral2.v1 | No |  |
| Xiaomi Philips Eyecare Smart Lamp 2 | miio:basic | philips.light.sread1 | Yes |  |
| Xiaomi Philips LED Ceiling Lamp | miio:basic | philips.light.ceiling | Yes |  |
| Xiaomi Philips LED Ceiling Lamp | miio:basic | philips.light.zyceiling | Yes |  |
| Xiaomi Philips Bulb | miio:basic | philips.light.bulb | Yes |  |
| Xiaomi Philips Downlight | miio:basic | philips.light.downlight | Yes |  |
| Mi Power-plug | miio:basic | chuangmi.plug.m1 | Yes |  |
| Mi Power-plug v1 | miio:basic | chuangmi.plug.v1 | Yes |  |
| Mi Power-plug v2 | miio:basic | chuangmi.plug.v2 | Yes |  |
| Mi Power-plug v3 | miio:basic | chuangmi.plug.v3 | Yes |  |
| Qing Mi Smart Power Strip v1 | miio:basic | qmi.powerstrip.v1 | Yes |  |
| Mi Power-strip v2 | miio:basic | zimi.powerstrip.v2 | Yes |  |
| Mi Toothbrush | miio:unsupported | soocare.toothbrush.x3 | No |  |
| Mi Robot Vacuum | miio:vacuum | rockrobo.vacuum.v1 | Yes |  |
| Mi Robot Vacuum v2 | miio:vacuum | roborock.vacuum.s5 | Yes |  |
| Mi Water Purifier v2 | miio:basic | yunmi.waterpuri.v2 | Yes |  |
| Xiaomi Wifi Extender | miio:unsupported | xiaomi.repeater.v2 | No |  |
| Mi Internet Speaker | miio:unsupported | xiaomi.wifispeaker.v1 | No |  |
| Yeelight Lamp | miio:basic | yeelink.light.bslamp1 | Yes |  |
| Yeelight Color Bulb | miio:basic | yeelink.light.color1 | Yes |  |
| Yeelight Color Bulb YLDP06YL 10W | miio:basic | yeelink.light.color2 | Yes |  |
| Yeelight LED Ceiling Lamp | miio:basic | yeelink.light.ceiling1 | Yes |  |
| Yeelight LED Ceiling Lamp v2 | miio:basic | yeelink.light.ceiling2 | Yes |  |
| Yeelight LED Ceiling Lamp v3 | miio:basic | yeelink.light.ceiling3 | Yes |  |
| Yeelight LED Ceiling Lamp v4 (JIAOYUE 650 RGB) | miio:basic | yeelink.light.ceiling4 | Yes |  |
| Yeelight | miio:basic | yeelink.light.lamp1 | Yes |  |
| Yeelight White Bulb | miio:basic | yeelink.light.mono1 | Yes |  |
| Yeelight White Bulb v2 | miio:basic | yeelink.light.mono2 | Yes |  |
| Yeelight Strip | miio:basic | yeelink.light.strip1 | Yes |  |



# Discovery

The binding has 2 methods for discovering devices. Depending on your network setup and the device model, your device may be discovered by one or both methods. If both methods discover your device, 2 discovery results may be in your inbox for the same device.

The MDNS discovery method will discover your device type, but won't discover a (required) token.
The basic discovery will not discovery the type, but will discover a token for models that support it.

## Tokens

The binding needs a token from the Xiaomi Mi Device in order to be able to control it.
Some devices provide the token upon discovery. This may depends on the firmware version.

If the device does not discover your token, it needs to be retrieved from the Mi Home app.
Note: latest Android MiHome no longer has the tokens in the database. Use 5.0.19 version or lower 
The token needs to be retrieved from the application database. The easiest way on Android to do is by using [MiToolkit](https://github.com/ultrara1n/MiToolkit/releases).

Alternatively, on Android open a backup file, or browse a rooted device, find the mio2db file with and read it sqlite.

For iPhone, use an un-encrypted iTunes-Backup and unpack it and use a sqlite tool to view the files in it: 
Then search in "RAW, com.xiaomi.home," for "USERID_mihome.sqlite" and look for the 32-digit-token or 96 digit encrypted token.

Note. The Xiaomi devices change the token when inclusion is done. Hence if you get your token after reset and than include it with the Mi Home app, the token will change.

## Binding Configuration

No binding configuration is required.

## Thing Configuration

The binding needs ip address and token to be able to communicate. See discovery for details.
Optional configuration is the refresh interval and the deviceID. Note that the deviceID is automatically retrieved when it is left blank.
The configuration for model is automatically retreived from the device in normal operation. However, for devices that are unsupported, you may try to use a model from a similar device to experimentally use your device with the binding  


## Channels

Depending on the device, different  channels are available.

note: the ADVANCED  `actions#commands` channel can be used to send commands that are not automated via the binding. This is available for all devices
e.g. `smarthome:send actionCommand  "upd_timer['1498595904821', 'on']"` would enable a pre-configured timer. See https://github.com/marcelrv/XiaomiRobotVacuumProtocol for all known available commands.


### Mi Air Monitor v1 (zhimi.airmonitor.v1 ) Channels


| Channel | Type | Description |
| ----- | ----- | -------------------------------- |
| aqi | Number | Air Quality Index | 
| battery | Number | Battery | 
| usb_state | Number | USB State | 


### Mi Air Humidifier (zhimi.humidifier.v1 ) Channels


| Channel | Type | Description |
| ----- | ----- | -------------------------------- |
| power | Switch | Power | 
| mode | String | Mode | 
| humidity | Number | Humidity | 
| setHumidity | Number | Humidity Set | 
| aqi | Number | Air Quality Index | 
| translevel | Number | Trans_level | 
| bright | Number | Led Brightness | 
| buzzer | Switch | Buzzer Status | 
| depth | Number | Depth | 
| dry | Switch | Dry | 
| usedhours | Number | Run Time | 
| motorspeed | Number | Motor Speed | 
| temperature | Number | Temperature | 
| childlock | Switch | Child Lock | 


### Mi Air Humidifier (zhimi.humidifier.ca1 ) Channels


| Channel | Type | Description |
| ----- | ----- | -------------------------------- |
| power | Switch | Power | 
| mode | String | Mode | 
| humidity | Number | Humidity | 
| setHumidity | Number | Humidity Set | 
| aqi | Number | Air Quality Index | 
| translevel | Number | Trans_level | 
| bright | Number | Led Brightness | 
| buzzer | Switch | Buzzer Status | 
| depth | Number | Depth | 
| dry | Switch | Dry | 
| usedhours | Number | Run Time | 
| motorspeed | Number | Motor Speed | 
| temperature | Number | Temperature | 
| childlock | Switch | Child Lock | 


### Mi Air Purifier v1 (zhimi.airpurifier.v1 ) Channels


| Channel | Type | Description |
| ----- | ----- | -------------------------------- |
| power | Switch | Power | 
| mode | String | Mode | 
| humidity | Number | Humidity | 
| aqi | Number | Air Quality Index | 
| averageaqi | Number | Average Air Quality Index | 
| led | Switch | Led Status | 
| buzzer | Switch | Buzzer Status | 
| filtermaxlife | Number | Filter Max Life | 
| filterhours | Number | Filter Hours used | 
| usedhours | Number | Run Time | 
| motorspeed | Number | Motor Speed | 
| filterlife | Number | Filter  Life | 
| favoritelevel | Number | Favorite Level | 
| temperature | Number | Temperature | 
| purifyvolume | Number | Purivied Volume | 
| childlock | Switch | Child Lock | 


### Mi Air Purifier v2 (zhimi.airpurifier.v2 ) Channels


| Channel | Type | Description |
| ----- | ----- | -------------------------------- |
| power | Switch | Power | 
| mode | String | Mode | 
| humidity | Number | Humidity | 
| aqi | Number | Air Quality Index | 
| averageaqi | Number | Average Air Quality Index | 
| led | Switch | Led Status | 
| buzzer | Switch | Buzzer Status | 
| filtermaxlife | Number | Filter Max Life | 
| filterhours | Number | Filter Hours used | 
| usedhours | Number | Run Time | 
| motorspeed | Number | Motor Speed | 
| filterlife | Number | Filter  Life | 
| favoritelevel | Number | Favorite Level | 
| temperature | Number | Temperature | 
| purifyvolume | Number | Purivied Volume | 
| childlock | Switch | Child Lock | 


### Mi Air Purifier v3 (zhimi.airpurifier.v3 ) Channels


| Channel | Type | Description |
| ----- | ----- | -------------------------------- |
| power | Switch | Power | 
| mode | String | Mode | 
| humidity | Number | Humidity | 
| aqi | Number | Air Quality Index | 
| averageaqi | Number | Average Air Quality Index | 
| led | Switch | Led Status | 
| buzzer | Switch | Buzzer Status | 
| filtermaxlife | Number | Filter Max Life | 
| filterhours | Number | Filter Hours used | 
| usedhours | Number | Run Time | 
| motorspeed | Number | Motor Speed | 
| filterlife | Number | Filter  Life | 
| favoritelevel | Number | Favorite Level | 
| temperature | Number | Temperature | 
| purifyvolume | Number | Purivied Volume | 
| childlock | Switch | Child Lock | 


### Mi Air Purifier Pro v6 (zhimi.airpurifier.v6 ) Channels


| Channel | Type | Description |
| ----- | ----- | -------------------------------- |
| power | Switch | Power | 
| mode | String | Mode | 
| humidity | Number | Humidity | 
| aqi | Number | Air Quality Index | 
| averageaqi | Number | Average Air Quality Index | 
| led | Switch | Led Status | 
| bright | Number | Led Brightness | 
| filtermaxlife | Number | Filter Max Life | 
| filterhours | Number | Filter Hours used | 
| usedhours | Number | Run Time | 
| motorspeed | Number | Motor Speed | 
| filterlife | Number | Filter  Life | 
| favoritelevel | Number | Favorite Level | 
| temperature | Number | Temperature | 
| purifyvolume | Number | Purivied Volume | 
| childlock | Switch | Child Lock | 


### Mi Air Purifier 2 (mini) (zhimi.airpurifier.m1 ) Channels


| Channel | Type | Description |
| ----- | ----- | -------------------------------- |
| power | Switch | Power | 
| mode | String | Mode | 
| humidity | Number | Humidity | 
| aqi | Number | Air Quality Index | 
| averageaqi | Number | Average Air Quality Index | 
| led | Switch | Led Status | 
| buzzer | Switch | Buzzer Status | 
| filtermaxlife | Number | Filter Max Life | 
| filterhours | Number | Filter Hours used | 
| usedhours | Number | Run Time | 
| motorspeed | Number | Motor Speed | 
| filterlife | Number | Filter  Life | 
| favoritelevel | Number | Favorite Level | 
| temperature | Number | Temperature | 
| purifyvolume | Number | Purivied Volume | 
| childlock | Switch | Child Lock | 


### Mi Air Purifier (mini) (zhimi.airpurifier.m2 ) Channels


| Channel | Type | Description |
| ----- | ----- | -------------------------------- |
| power | Switch | Power | 
| mode | String | Mode | 
| humidity | Number | Humidity | 
| aqi | Number | Air Quality Index | 
| averageaqi | Number | Average Air Quality Index | 
| led | Switch | Led Status | 
| buzzer | Switch | Buzzer Status | 
| filtermaxlife | Number | Filter Max Life | 
| filterhours | Number | Filter Hours used | 
| usedhours | Number | Run Time | 
| motorspeed | Number | Motor Speed | 
| filterlife | Number | Filter  Life | 
| favoritelevel | Number | Favorite Level | 
| temperature | Number | Temperature | 
| purifyvolume | Number | Purivied Volume | 
| childlock | Switch | Child Lock | 


### Mi Air Purifier MS2 (zhimi.airpurifier.ma2 ) Channels


| Channel | Type | Description |
| ----- | ----- | -------------------------------- |
| power | Switch | Power | 
| mode | String | Mode | 
| humidity | Number | Humidity | 
| aqi | Number | Air Quality Index | 
| averageaqi | Number | Average Air Quality Index | 
| led | Switch | Led Status | 
| bright | Number | Led Brightness | 
| filtermaxlife | Number | Filter Max Life | 
| filterhours | Number | Filter Hours used | 
| usedhours | Number | Run Time | 
| motorspeed | Number | Motor Speed | 
| filterlife | Number | Filter  Life | 
| favoritelevel | Number | Favorite Level | 
| temperature | Number | Temperature | 
| purifyvolume | Number | Purivied Volume | 
| childlock | Switch | Child Lock | 


### Mi Smart Fan (zhimi.fan.v1 ) Channels


| Channel | Type | Description |
| ----- | ----- | -------------------------------- |
| power | Switch | Power | 
| angleEnable | Switch | Rotation | 
| usedhours | Number | Run Time | 
| angle | Number | Angle  | 
| poweroffTime | Number | Timer  | 
| buzzer | Switch | Buzzer  | 
| led_b | Number | Led  | 
| child_lock | Switch | Child Lock  | 
| speedLevel | Number | Speed Level | 
| speed | Number | Speed | 
| naturalLevel | Number | Natural Level | 
| temp_dec | Number | Temperature | 
| humidity | Number | Humidity | 
| acPower | String | AC Power | 
| mode | String | Battery Charge | 
| battery | Number | Battery | 
| move | String | Move Direction  | 


### Mi Smart Fan (zhimi.fan.v2 ) Channels


| Channel | Type | Description |
| ----- | ----- | -------------------------------- |
| power | Switch | Power | 
| angleEnable | Switch | Rotation | 
| usedhours | Number | Run Time | 
| angle | Number | Angle  | 
| poweroffTime | Number | Timer  | 
| buzzer | Switch | Buzzer  | 
| led_b | Number | Led  | 
| child_lock | Switch | Child Lock  | 
| speedLevel | Number | Speed Level | 
| speed | Number | Speed | 
| naturalLevel | Number | Natural Level | 
| temp_dec | Number | Temperature | 
| humidity | Number | Humidity | 
| acPower | String | AC Power | 
| mode | String | Battery Charge | 
| battery | Number | Battery | 
| move | String | Move Direction  | 


### Mi Smart Pedestal Fan (zhimi.fan.v3 ) Channels


| Channel | Type | Description |
| ----- | ----- | -------------------------------- |
| power | Switch | Power | 
| angleEnable | Switch | Rotation | 
| usedhours | Number | Run Time | 
| angle | Number | Angle  | 
| poweroffTime | Number | Timer  | 
| buzzer | Switch | Buzzer  | 
| led_b | Number | Led  | 
| child_lock | Switch | Child Lock  | 
| speedLevel | Number | Speed Level | 
| speed | Number | Speed | 
| naturalLevel | Number | Natural Level | 
| temp_dec | Number | Temperature | 
| humidity | Number | Humidity | 
| acPower | String | AC Power | 
| mode | String | Battery Charge | 
| battery | Number | Battery | 
| move | String | Move Direction  | 


### Mi Humdifier (zhimi.humidifier.v1 ) Channels


| Channel | Type | Description |
| ----- | ----- | -------------------------------- |
| power | Switch | Power | 
| mode | String | Mode | 
| humidity | Number | Humidity | 
| setHumidity | Number | Humidity Set | 
| aqi | Number | Air Quality Index | 
| translevel | Number | Trans_level | 
| bright | Number | Led Brightness | 
| buzzer | Switch | Buzzer Status | 
| depth | Number | Depth | 
| dry | Switch | Dry | 
| usedhours | Number | Run Time | 
| motorspeed | Number | Motor Speed | 
| temperature | Number | Temperature | 
| childlock | Switch | Child Lock | 


### Xiaomi Philips Eyecare Smart Lamp 2 (philips.light.sread1 ) Channels


| Channel | Type | Description |
| ----- | ----- | -------------------------------- |
| power | Switch | Power | 
| brightness | Number | Brightness | 
| ambientPower | Switch | Ambient Power | 
| ambientBrightness | Number | Ambient Brightness | 
| illumination | Number | Ambient Illumination | 
| eyecare | Switch | Eyecare | 


### Xiaomi Philips LED Ceiling Lamp (philips.light.ceiling ) Channels


| Channel | Type | Description |
| ----- | ----- | -------------------------------- |
| power | Switch | Power | 
| brightness | Number | Brightness | 
| cct | Number | Correlated Color Temperature | 
| scene | Number | Scene | 
| switchscene | Switch | Switch Scene | 
| toggle | Switch | Toggle | 


### Xiaomi Philips LED Ceiling Lamp (philips.light.zyceiling ) Channels


| Channel | Type | Description |
| ----- | ----- | -------------------------------- |
| power | Switch | Power | 
| brightness | Number | Brightness | 
| cct | Number | Correlated Color Temperature | 
| scene | Number | Scene | 
| switchscene | Switch | Switch Scene | 
| toggle | Switch | Toggle | 


### Xiaomi Philips Bulb (philips.light.bulb ) Channels


| Channel | Type | Description |
| ----- | ----- | -------------------------------- |
| power | Switch | Power | 
| brightness | Number | Brightness | 
| cct | Number | Correlated Color Temperature | 
| scene | Number | Scene | 
| dv | Number | DV | 
| switchscene | Switch | Switch Scene | 
| delayoff | Switch | Delay Off | 
| toggle | Switch | Toggle | 


### Xiaomi Philips Downlight (philips.light.downlight ) Channels


| Channel | Type | Description |
| ----- | ----- | -------------------------------- |
| power | Switch | Power | 
| brightness | Number | Brightness | 
| cct | Number | Correlated Color Temperature | 
| scene | Number | Scene | 
| dv | Number | DV | 
| switchscene | Switch | Switch Scene | 
| delayoff | Switch | Delay Off | 
| toggle | Switch | Toggle | 


### Mi Power-plug (chuangmi.plug.m1 ) Channels


| Channel | Type | Description |
| ----- | ----- | -------------------------------- |
| power | Switch | Power | 
| temperature | Number | Temperature | 


### Mi Power-plug v1 (chuangmi.plug.v1 ) Channels


| Channel | Type | Description |
| ----- | ----- | -------------------------------- |
| power | Switch | Power | 
| usb | OnOffType | USB | 


### Mi Power-plug v2 (chuangmi.plug.v2 ) Channels


| Channel | Type | Description |
| ----- | ----- | -------------------------------- |
| power | Switch | Power | 
| usb | OnOffType | USB | 


### Mi Power-plug v3 (chuangmi.plug.v3 ) Channels


| Channel | Type | Description |
| ----- | ----- | -------------------------------- |
| power | Switch | Power | 
| usb | OnOffType | USB | 
| temperature | Number | Temperature | 
| led | Switch | Wifi led | 


### Qing Mi Smart Power Strip v1 (qmi.powerstrip.v1 ) Channels


| Channel | Type | Description |
| ----- | ----- | -------------------------------- |
| power | Switch | Power | 
| powerUsage | Number | Power Consumption | 
| led | Switch | wifi_led | 
| power_price | Number | power_price | 
| current | Number | Current | 
| temperature | Number | Temperature | 


### Mi Power-strip v2 (zimi.powerstrip.v2 ) Channels


| Channel | Type | Description |
| ----- | ----- | -------------------------------- |
| power | Switch | Power | 
| powerUsage | Number | Power Consumption | 
| led | Switch | wifi_led | 
| power_price | Number | power_price | 
| current | Number | Current | 
| temperature | Number | Temperature | 


### Mi Water Purifier v2 (yunmi.waterpuri.v2 ) Channels


| Channel | Type | Description |
| ----- | ----- | -------------------------------- |
| power | Switch | Power | 


### Yeelight Lamp (yeelink.light.bslamp1 ) Channels


| Channel | Type | Description |
| ----- | ----- | -------------------------------- |
| power | Switch | Power | 
| brightness | Number | Brightness | 
| delayoff | Number | delayoff | 
| colorTemperature | Number | Color Temperature  | 
| colorMode | Number | colorMode | 
| name | String | Name | 


### Yeelight Color Bulb (yeelink.light.color1 ) Channels


| Channel | Type | Description |
| ----- | ----- | -------------------------------- |
| power | Switch | Power | 
| brightness | Number | Brightness | 
| delayoff | String | delayoff | 
| colorTemperature | Number | Color Temperature  | 
| colorMode | String | colorMode | 
| toggle | Switch | toggle | 
| color | Color | color | 
| name | String | Name | 


### Yeelight Color Bulb YLDP06YL 10W (yeelink.light.color2 ) Channels


| Channel | Type | Description |
| ----- | ----- | -------------------------------- |
| power | Switch | Power | 
| brightness | Number | Brightness | 
| delayoff | String | delayoff | 
| colorTemperature | Number | Color Temperature  | 
| colorMode | String | colorMode | 
| toggle | Switch | toggle | 
| color | Color | color | 
| name | String | Name | 


### Yeelight LED Ceiling Lamp (yeelink.light.ceiling1 ) Channels


| Channel | Type | Description |
| ----- | ----- | -------------------------------- |
| power | Switch | Power | 
| brightness | Number | Brightness | 
| delayoff | Number | delayoff | 
| colorTemperature | Number | Color Temperature  | 
| colorMode | Number | colorMode | 
| name | String | Name | 


### Yeelight LED Ceiling Lamp v2 (yeelink.light.ceiling2 ) Channels


| Channel | Type | Description |
| ----- | ----- | -------------------------------- |
| power | Switch | Power | 
| brightness | Number | Brightness | 
| delayoff | Number | delayoff | 
| colorTemperature | Number | Color Temperature  | 
| colorMode | Number | colorMode | 
| name | String | Name | 


### Yeelight LED Ceiling Lamp v3 (yeelink.light.ceiling3 ) Channels


| Channel | Type | Description |
| ----- | ----- | -------------------------------- |
| power | Switch | Power | 
| brightness | Number | Brightness | 
| delayoff | Number | delayoff | 
| colorTemperature | Number | Color Temperature  | 
| colorMode | Number | colorMode | 
| name | String | Name | 


### Yeelight LED Ceiling Lamp v4 (JIAOYUE 650 RGB) (yeelink.light.ceiling4 ) Channels


| Channel | Type | Description |
| ----- | ----- | -------------------------------- |
| power | Switch | Power | 
| brightness | Number | Brightness | 
| ambientBrightness | Number | Ambient Brightness | 
| delayoff | Number | delayoff | 
| colorTemperature | Number | Color Temperature  | 
| colorMode | Number | Color Mode | 
| name | String | Name | 
| ambientPower | Switch | Ambient Power | 
| ambientColor | Color | Ambient Color | 
| ambientColorTemperature | Number | Ambient Color Temperature  | 
| customScene | String | Set Scene | 
| ambientColorMode | Number | Ambient Color Mode | 
| nightlightBrightness | Number | Nightlight Brightness | 


### Yeelight (yeelink.light.lamp1 ) Channels


| Channel | Type | Description |
| ----- | ----- | -------------------------------- |
| power | Switch | Power | 
| brightness | Number | Brightness | 
| delayoff | Number | delayoff | 
| colorTemperature | Number | Color Temperature  | 
| colorMode | Number | colorMode | 
| name | String | Name | 


### Yeelight White Bulb (yeelink.light.mono1 ) Channels


| Channel | Type | Description |
| ----- | ----- | -------------------------------- |
| power | Switch | Power | 
| brightness | Number | Brightness | 
| delayoff | Number | delayoff | 
| colorTemperature | Number | Color Temperature  | 
| colorMode | Number | colorMode | 
| name | String | Name | 


### Yeelight White Bulb v2 (yeelink.light.mono2 ) Channels


| Channel | Type | Description |
| ----- | ----- | -------------------------------- |
| power | Switch | Power | 
| brightness | Number | Brightness | 
| delayoff | Number | delayoff | 
| colorTemperature | Number | Color Temperature  | 
| colorMode | Number | colorMode | 
| name | String | Name | 


### Yeelight Strip (yeelink.light.strip1 ) Channels


| Channel | Type | Description |
| ----- | ----- | -------------------------------- |
| power | Switch | Power | 
| brightness | Number | Brightness | 
| delayoff | Number | delayoff | 
| colorTemperature | Number | Color Temperature  | 
| colorMode | Number | colorMode | 
| name | String | Name | 



## Example item file Rockrobo vacuum

```
Group  gVac     "Xiaomi Robot Vacuum"      <fan>
Group  gVacStat "Status Details"           <status> (gVac)
Group  gVacCons "Consumables Usage"        <line-increase> (gVac)
Group  gVacDND  "Do Not Disturb Settings"  <moon> (gVac)
Group  gVacHist "Cleaning History"         <calendar> (gVac)

String actionControl  "Vacuum Control"          {channel="xiaomivacuum:vacuum:034F0E45:actions#control" }
String actionCommand  "Vacuum Command"          {channel="xiaomivacuum:vacuum:034F0E45:actions#commands" }

Number statusBat    "Battery Level [%1.0f%%]" <battery>   (gVac,gVacStat) {channel="xiaomivacuum:vacuum:034F0E45:status#battery" }
Number statusArea    "Cleaned Area [%1.0fm²]" <zoom>   (gVac,gVacStat) {channel="xiaomivacuum:vacuum:034F0E45:status#clean_area" }
Number statusTime    "Cleaning Time [%1.0f']" <clock>   (gVac,gVacStat) {channel="xiaomivacuum:vacuum:034F0E45:status#clean_time" }
String  statusError    "Error [%s]"  <error>  (gVac,gVacStat) {channel="xiaomivacuum:vacuum:034F0E45:status#error_code" }
Number statusFanPow    "Fan Power [%1.0f %%]"  <signal>   (gVacStat) {channel="xiaomivacuum:vacuum:034F0E45:status#fan_power" } 
Number statusClean    "In Cleaning Status [%1.0f]"   <switch>  (gVacStat) {channel="xiaomivacuum:vacuum:034F0E45:status#in_cleaning" }
Switch statusDND    "DND Activated"    (gVacStat) {channel="xiaomivacuum:vacuum:034F0E45:status#dnd_enabled" }
Number statusStatus    "Status [%1.0f]"  <status>  (gVacStat) {channel="xiaomivacuum:vacuum:034F0E45:status#state"} 

Number consumableMain    "Main Brush [%1.0f]"    (gVacCons) {channel="xiaomivacuum:vacuum:034F0E45:consumables#main_brush_time"}
Number consumableSide    "Side Brush [%1.0f]"    (gVacCons) {channel="xiaomivacuum:vacuum:034F0E45:consumables#side_brush_time"}
Number consumableFilter    "Filter Time[%1.0f]"    (gVacCons) {channel="xiaomivacuum:vacuum:034F0E45:consumables#filter_time" }
Number consumableSensor    "Sensor [%1.0f]"    (gVacCons) {channel="xiaomivacuum:vacuum:034F0E45:consumables#sensor_dirt_time"}

Switch dndFunction   "DND Function" <moon>   (gVacDND) {channel="xiaomivacuum:vacuum:034F0E45:dnd#dnd_function"}
String dndStart   "DND Start Time [%s]" <clock>   (gVacDND) {channel="xiaomivacuum:vacuum:034F0E45:dnd#dnd_start"}
String dndEnd   "DND End Time [%s]"   <clock-on>  (gVacDND) {channel="xiaomivacuum:vacuum:034F0E45:dnd#dnd_end"}

Number historyArea    "Total Cleaned Area [%1.0fm²]" <zoom>    (gVacHist) {channel="xiaomivacuum:vacuum:034F0E45:history#total_clean_area"}
String historyTime    "Total Clean Time [%s]"   <clock>     (gVacHist) {channel="xiaomivacuum:vacuum:034F0E45:history#total_clean_time"}
Number historyCount    "Total # Cleanings [%1.0f]"  <office>  (gVacHist) {channel="xiaomivacuum:vacuum:034F0E45:history#total_clean_count"}
```

