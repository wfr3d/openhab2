# Xiaomi Mi IO Binding

This binding is used to control Xiaomi products implementing the Mi IO protocol. 
This is a set of wifi devices from Xiaomi that are part of the Mi Ecosystem which is branded as MiJia.

![MIIO logo](doc/miio.png)

## Supported Things

The following things are available:

| Thing Type | Description |
|--------|---------| 
| miio:generic | Generic type for discovered devices. Once the token is available and the device model is determined, this Thing Type will automatically change to the appropriate Thing Type |
| miio:vacuum | For Xiaomi Robot Vacuum products|
| miio:gateway | For Xiaomi Gateway |
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
| Xiaomi Mi Smart Pedestal Fan | miio:basic | zhimi.fan.sa1 | Yes |  |
| Xiaomi Mi Smart Pedestal Fan | miio:basic | zhimi.fan.za1 | Yes |  |
| Mi Smart Home Gateway v1 | miio:unsupported | lumi.gateway.v1 | No |  |
| Mi Smart Home Gateway v2 | miio:unsupported | lumi.gateway.v2 | No |  |
| Mi Smart Home Gateway v3 | miio:gateway | lumi.gateway.v3 | Development in progress | Only basic functions |
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

Each Xiami device (thing) needs the IP address and token configured to be able to communicate. See discovery for details.
Optional configuration is the refresh interval and the deviceID. Note that the deviceID is automatically retrieved when it is left blank.
The configuration for model is automatically retrieved from the device in normal operation. 
However, for devices that are unsupported, you may override the value and try to use a model string from a similar device to experimentally use your device with the binding.


## Channels

Depending on the device, different channels are available.

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


### Xiaomi Mi Smart Pedestal Fan (zhimi.fan.sa1 ) Channels


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
| acPower | Switch | AC Power | 
| move | String | Move Direction  | 


### Xiaomi Mi Smart Pedestal Fan (zhimi.fan.za1 ) Channels


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
| acPower | Switch | AC Power | 
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

String actionControl  "Vacuum Control"          {channel="miio:vacuum:034F0E45:actions#control" }
String actionCommand  "Vacuum Command"          {channel="miio:vacuum:034F0E45:actions#commands" }

Number statusBat    "Battery Level [%1.0f%%]" <battery>   (gVac,gVacStat) {channel="miio:vacuum:034F0E45:status#battery" }
Number statusArea    "Cleaned Area [%1.0fm²]" <zoom>   (gVac,gVacStat) {channel="miio:vacuum:034F0E45:status#clean_area" }
Number statusTime    "Cleaning Time [%1.0f']" <clock>   (gVac,gVacStat) {channel="miio:vacuum:034F0E45:status#clean_time" }
String  statusError    "Error [%s]"  <error>  (gVac,gVacStat) {channel="miio:vacuum:034F0E45:status#error_code" }
Number statusFanPow    "Fan Power [%1.0f %%]"  <signal>   (gVacStat) {channel="miio:vacuum:034F0E45:status#fan_power" } 
Number statusClean    "In Cleaning Status [%1.0f]"   <switch>  (gVacStat) {channel="miio:vacuum:034F0E45:status#in_cleaning" }
Switch statusDND    "DND Activated"    (gVacStat) {channel="miio:vacuum:034F0E45:status#dnd_enabled" }
Number statusStatus    "Status [%1.0f]"  <status>  (gVacStat) {channel="miio:vacuum:034F0E45:status#state"} 

Number consumableMain    "Main Brush [%1.0f]"    (gVacCons) {channel="miio:vacuum:034F0E45:consumables#main_brush_time"}
Number consumableSide    "Side Brush [%1.0f]"    (gVacCons) {channel="miio:vacuum:034F0E45:consumables#side_brush_time"}
Number consumableFilter    "Filter Time[%1.0f]"    (gVacCons) {channel="miio:vacuum:034F0E45:consumables#filter_time" }
Number consumableSensor    "Sensor [%1.0f]"    (gVacCons) {channel="miio:vacuum:034F0E45:consumables#sensor_dirt_time"}

Switch dndFunction   "DND Function" <moon>   (gVacDND) {channel="miio:vacuum:034F0E45:dnd#dnd_function"}
String dndStart   "DND Start Time [%s]" <clock>   (gVacDND) {channel="miio:vacuum:034F0E45:dnd#dnd_start"}
String dndEnd   "DND End Time [%s]"   <clock-on>  (gVacDND) {channel="miio:vacuum:034F0E45:dnd#dnd_end"}

Number historyArea    "Total Cleaned Area [%1.0fm²]" <zoom>    (gVacHist) {channel="miio:vacuum:034F0E45:history#total_clean_area"}
String historyTime    "Total Clean Time [%s]"   <clock>     (gVacHist) {channel="miio:vacuum:034F0E45:history#total_clean_time"}
Number historyCount    "Total # Cleanings [%1.0f]"  <office>  (gVacHist) {channel="miio:vacuum:034F0E45:history#total_clean_count"}
```


### Mi Air Monitor v1 (zhimi.airmonitor.v1) item file lines


note: Autogenerated example. Replace the id (airmonitor) in the channel with your own.

```
Group G_airmonitor "Mi Air Monitor v1" <status>
Number aqi "Air Quality Index" (G_airmonitor) {channel="miio:basic:airmonitor:aqi"}
Number battery "Battery" (G_airmonitor) {channel="miio:basic:airmonitor:battery"}
Number usb_state "USB State" (G_airmonitor) {channel="miio:basic:airmonitor:usb_state"}
```

### Mi Air Humidifier (zhimi.humidifier.v1) item file lines


note: Autogenerated example. Replace the id (humidifier) in the channel with your own.

```
Group G_humidifier "Mi Air Humidifier" <status>
Switch power "Power" (G_humidifier) {channel="miio:basic:humidifier:power"}
String mode "Mode" (G_humidifier) {channel="miio:basic:humidifier:mode"}
Number humidity "Humidity" (G_humidifier) {channel="miio:basic:humidifier:humidity"}
Number setHumidity "Humidity Set" (G_humidifier) {channel="miio:basic:humidifier:setHumidity"}
Number aqi "Air Quality Index" (G_humidifier) {channel="miio:basic:humidifier:aqi"}
Number translevel "Trans_level" (G_humidifier) {channel="miio:basic:humidifier:translevel"}
Number bright "Led Brightness" (G_humidifier) {channel="miio:basic:humidifier:bright"}
Switch buzzer "Buzzer Status" (G_humidifier) {channel="miio:basic:humidifier:buzzer"}
Number depth "Depth" (G_humidifier) {channel="miio:basic:humidifier:depth"}
Switch dry "Dry" (G_humidifier) {channel="miio:basic:humidifier:dry"}
Number usedhours "Run Time" (G_humidifier) {channel="miio:basic:humidifier:usedhours"}
Number motorspeed "Motor Speed" (G_humidifier) {channel="miio:basic:humidifier:motorspeed"}
Number temperature "Temperature" (G_humidifier) {channel="miio:basic:humidifier:temperature"}
Switch childlock "Child Lock" (G_humidifier) {channel="miio:basic:humidifier:childlock"}
```

### Mi Air Humidifier (zhimi.humidifier.ca1) item file lines


note: Autogenerated example. Replace the id (humidifier) in the channel with your own.

```
Group G_humidifier "Mi Air Humidifier" <status>
Switch power "Power" (G_humidifier) {channel="miio:basic:humidifier:power"}
String mode "Mode" (G_humidifier) {channel="miio:basic:humidifier:mode"}
Number humidity "Humidity" (G_humidifier) {channel="miio:basic:humidifier:humidity"}
Number setHumidity "Humidity Set" (G_humidifier) {channel="miio:basic:humidifier:setHumidity"}
Number aqi "Air Quality Index" (G_humidifier) {channel="miio:basic:humidifier:aqi"}
Number translevel "Trans_level" (G_humidifier) {channel="miio:basic:humidifier:translevel"}
Number bright "Led Brightness" (G_humidifier) {channel="miio:basic:humidifier:bright"}
Switch buzzer "Buzzer Status" (G_humidifier) {channel="miio:basic:humidifier:buzzer"}
Number depth "Depth" (G_humidifier) {channel="miio:basic:humidifier:depth"}
Switch dry "Dry" (G_humidifier) {channel="miio:basic:humidifier:dry"}
Number usedhours "Run Time" (G_humidifier) {channel="miio:basic:humidifier:usedhours"}
Number motorspeed "Motor Speed" (G_humidifier) {channel="miio:basic:humidifier:motorspeed"}
Number temperature "Temperature" (G_humidifier) {channel="miio:basic:humidifier:temperature"}
Switch childlock "Child Lock" (G_humidifier) {channel="miio:basic:humidifier:childlock"}
```

### Mi Air Purifier v1 (zhimi.airpurifier.v1) item file lines


note: Autogenerated example. Replace the id (airpurifier) in the channel with your own.

```
Group G_airpurifier "Mi Air Purifier v1" <status>
Switch power "Power" (G_airpurifier) {channel="miio:basic:airpurifier:power"}
String mode "Mode" (G_airpurifier) {channel="miio:basic:airpurifier:mode"}
Number humidity "Humidity" (G_airpurifier) {channel="miio:basic:airpurifier:humidity"}
Number aqi "Air Quality Index" (G_airpurifier) {channel="miio:basic:airpurifier:aqi"}
Number averageaqi "Average Air Quality Index" (G_airpurifier) {channel="miio:basic:airpurifier:averageaqi"}
Switch led "Led Status" (G_airpurifier) {channel="miio:basic:airpurifier:led"}
Switch buzzer "Buzzer Status" (G_airpurifier) {channel="miio:basic:airpurifier:buzzer"}
Number filtermaxlife "Filter Max Life" (G_airpurifier) {channel="miio:basic:airpurifier:filtermaxlife"}
Number filterhours "Filter Hours used" (G_airpurifier) {channel="miio:basic:airpurifier:filterhours"}
Number usedhours "Run Time" (G_airpurifier) {channel="miio:basic:airpurifier:usedhours"}
Number motorspeed "Motor Speed" (G_airpurifier) {channel="miio:basic:airpurifier:motorspeed"}
Number filterlife "Filter  Life" (G_airpurifier) {channel="miio:basic:airpurifier:filterlife"}
Number favoritelevel "Favorite Level" (G_airpurifier) {channel="miio:basic:airpurifier:favoritelevel"}
Number temperature "Temperature" (G_airpurifier) {channel="miio:basic:airpurifier:temperature"}
Number purifyvolume "Purivied Volume" (G_airpurifier) {channel="miio:basic:airpurifier:purifyvolume"}
Switch childlock "Child Lock" (G_airpurifier) {channel="miio:basic:airpurifier:childlock"}
```

### Mi Air Purifier v2 (zhimi.airpurifier.v2) item file lines


note: Autogenerated example. Replace the id (airpurifier) in the channel with your own.

```
Group G_airpurifier "Mi Air Purifier v2" <status>
Switch power "Power" (G_airpurifier) {channel="miio:basic:airpurifier:power"}
String mode "Mode" (G_airpurifier) {channel="miio:basic:airpurifier:mode"}
Number humidity "Humidity" (G_airpurifier) {channel="miio:basic:airpurifier:humidity"}
Number aqi "Air Quality Index" (G_airpurifier) {channel="miio:basic:airpurifier:aqi"}
Number averageaqi "Average Air Quality Index" (G_airpurifier) {channel="miio:basic:airpurifier:averageaqi"}
Switch led "Led Status" (G_airpurifier) {channel="miio:basic:airpurifier:led"}
Switch buzzer "Buzzer Status" (G_airpurifier) {channel="miio:basic:airpurifier:buzzer"}
Number filtermaxlife "Filter Max Life" (G_airpurifier) {channel="miio:basic:airpurifier:filtermaxlife"}
Number filterhours "Filter Hours used" (G_airpurifier) {channel="miio:basic:airpurifier:filterhours"}
Number usedhours "Run Time" (G_airpurifier) {channel="miio:basic:airpurifier:usedhours"}
Number motorspeed "Motor Speed" (G_airpurifier) {channel="miio:basic:airpurifier:motorspeed"}
Number filterlife "Filter  Life" (G_airpurifier) {channel="miio:basic:airpurifier:filterlife"}
Number favoritelevel "Favorite Level" (G_airpurifier) {channel="miio:basic:airpurifier:favoritelevel"}
Number temperature "Temperature" (G_airpurifier) {channel="miio:basic:airpurifier:temperature"}
Number purifyvolume "Purivied Volume" (G_airpurifier) {channel="miio:basic:airpurifier:purifyvolume"}
Switch childlock "Child Lock" (G_airpurifier) {channel="miio:basic:airpurifier:childlock"}
```

### Mi Air Purifier v3 (zhimi.airpurifier.v3) item file lines


note: Autogenerated example. Replace the id (airpurifier) in the channel with your own.

```
Group G_airpurifier "Mi Air Purifier v3" <status>
Switch power "Power" (G_airpurifier) {channel="miio:basic:airpurifier:power"}
String mode "Mode" (G_airpurifier) {channel="miio:basic:airpurifier:mode"}
Number humidity "Humidity" (G_airpurifier) {channel="miio:basic:airpurifier:humidity"}
Number aqi "Air Quality Index" (G_airpurifier) {channel="miio:basic:airpurifier:aqi"}
Number averageaqi "Average Air Quality Index" (G_airpurifier) {channel="miio:basic:airpurifier:averageaqi"}
Switch led "Led Status" (G_airpurifier) {channel="miio:basic:airpurifier:led"}
Switch buzzer "Buzzer Status" (G_airpurifier) {channel="miio:basic:airpurifier:buzzer"}
Number filtermaxlife "Filter Max Life" (G_airpurifier) {channel="miio:basic:airpurifier:filtermaxlife"}
Number filterhours "Filter Hours used" (G_airpurifier) {channel="miio:basic:airpurifier:filterhours"}
Number usedhours "Run Time" (G_airpurifier) {channel="miio:basic:airpurifier:usedhours"}
Number motorspeed "Motor Speed" (G_airpurifier) {channel="miio:basic:airpurifier:motorspeed"}
Number filterlife "Filter  Life" (G_airpurifier) {channel="miio:basic:airpurifier:filterlife"}
Number favoritelevel "Favorite Level" (G_airpurifier) {channel="miio:basic:airpurifier:favoritelevel"}
Number temperature "Temperature" (G_airpurifier) {channel="miio:basic:airpurifier:temperature"}
Number purifyvolume "Purivied Volume" (G_airpurifier) {channel="miio:basic:airpurifier:purifyvolume"}
Switch childlock "Child Lock" (G_airpurifier) {channel="miio:basic:airpurifier:childlock"}
```

### Mi Air Purifier Pro v6 (zhimi.airpurifier.v6) item file lines


note: Autogenerated example. Replace the id (airpurifier) in the channel with your own.

```
Group G_airpurifier "Mi Air Purifier Pro v6" <status>
Switch power "Power" (G_airpurifier) {channel="miio:basic:airpurifier:power"}
String mode "Mode" (G_airpurifier) {channel="miio:basic:airpurifier:mode"}
Number humidity "Humidity" (G_airpurifier) {channel="miio:basic:airpurifier:humidity"}
Number aqi "Air Quality Index" (G_airpurifier) {channel="miio:basic:airpurifier:aqi"}
Number averageaqi "Average Air Quality Index" (G_airpurifier) {channel="miio:basic:airpurifier:averageaqi"}
Switch led "Led Status" (G_airpurifier) {channel="miio:basic:airpurifier:led"}
Number bright "Led Brightness" (G_airpurifier) {channel="miio:basic:airpurifier:bright"}
Number filtermaxlife "Filter Max Life" (G_airpurifier) {channel="miio:basic:airpurifier:filtermaxlife"}
Number filterhours "Filter Hours used" (G_airpurifier) {channel="miio:basic:airpurifier:filterhours"}
Number usedhours "Run Time" (G_airpurifier) {channel="miio:basic:airpurifier:usedhours"}
Number motorspeed "Motor Speed" (G_airpurifier) {channel="miio:basic:airpurifier:motorspeed"}
Number filterlife "Filter  Life" (G_airpurifier) {channel="miio:basic:airpurifier:filterlife"}
Number favoritelevel "Favorite Level" (G_airpurifier) {channel="miio:basic:airpurifier:favoritelevel"}
Number temperature "Temperature" (G_airpurifier) {channel="miio:basic:airpurifier:temperature"}
Number purifyvolume "Purivied Volume" (G_airpurifier) {channel="miio:basic:airpurifier:purifyvolume"}
Switch childlock "Child Lock" (G_airpurifier) {channel="miio:basic:airpurifier:childlock"}
```

### Mi Air Purifier 2 (mini) (zhimi.airpurifier.m1) item file lines


note: Autogenerated example. Replace the id (airpurifier) in the channel with your own.

```
Group G_airpurifier "Mi Air Purifier 2 (mini)" <status>
Switch power "Power" (G_airpurifier) {channel="miio:basic:airpurifier:power"}
String mode "Mode" (G_airpurifier) {channel="miio:basic:airpurifier:mode"}
Number humidity "Humidity" (G_airpurifier) {channel="miio:basic:airpurifier:humidity"}
Number aqi "Air Quality Index" (G_airpurifier) {channel="miio:basic:airpurifier:aqi"}
Number averageaqi "Average Air Quality Index" (G_airpurifier) {channel="miio:basic:airpurifier:averageaqi"}
Switch led "Led Status" (G_airpurifier) {channel="miio:basic:airpurifier:led"}
Switch buzzer "Buzzer Status" (G_airpurifier) {channel="miio:basic:airpurifier:buzzer"}
Number filtermaxlife "Filter Max Life" (G_airpurifier) {channel="miio:basic:airpurifier:filtermaxlife"}
Number filterhours "Filter Hours used" (G_airpurifier) {channel="miio:basic:airpurifier:filterhours"}
Number usedhours "Run Time" (G_airpurifier) {channel="miio:basic:airpurifier:usedhours"}
Number motorspeed "Motor Speed" (G_airpurifier) {channel="miio:basic:airpurifier:motorspeed"}
Number filterlife "Filter  Life" (G_airpurifier) {channel="miio:basic:airpurifier:filterlife"}
Number favoritelevel "Favorite Level" (G_airpurifier) {channel="miio:basic:airpurifier:favoritelevel"}
Number temperature "Temperature" (G_airpurifier) {channel="miio:basic:airpurifier:temperature"}
Number purifyvolume "Purivied Volume" (G_airpurifier) {channel="miio:basic:airpurifier:purifyvolume"}
Switch childlock "Child Lock" (G_airpurifier) {channel="miio:basic:airpurifier:childlock"}
```

### Mi Air Purifier (mini) (zhimi.airpurifier.m2) item file lines


note: Autogenerated example. Replace the id (airpurifier) in the channel with your own.

```
Group G_airpurifier "Mi Air Purifier (mini)" <status>
Switch power "Power" (G_airpurifier) {channel="miio:basic:airpurifier:power"}
String mode "Mode" (G_airpurifier) {channel="miio:basic:airpurifier:mode"}
Number humidity "Humidity" (G_airpurifier) {channel="miio:basic:airpurifier:humidity"}
Number aqi "Air Quality Index" (G_airpurifier) {channel="miio:basic:airpurifier:aqi"}
Number averageaqi "Average Air Quality Index" (G_airpurifier) {channel="miio:basic:airpurifier:averageaqi"}
Switch led "Led Status" (G_airpurifier) {channel="miio:basic:airpurifier:led"}
Switch buzzer "Buzzer Status" (G_airpurifier) {channel="miio:basic:airpurifier:buzzer"}
Number filtermaxlife "Filter Max Life" (G_airpurifier) {channel="miio:basic:airpurifier:filtermaxlife"}
Number filterhours "Filter Hours used" (G_airpurifier) {channel="miio:basic:airpurifier:filterhours"}
Number usedhours "Run Time" (G_airpurifier) {channel="miio:basic:airpurifier:usedhours"}
Number motorspeed "Motor Speed" (G_airpurifier) {channel="miio:basic:airpurifier:motorspeed"}
Number filterlife "Filter  Life" (G_airpurifier) {channel="miio:basic:airpurifier:filterlife"}
Number favoritelevel "Favorite Level" (G_airpurifier) {channel="miio:basic:airpurifier:favoritelevel"}
Number temperature "Temperature" (G_airpurifier) {channel="miio:basic:airpurifier:temperature"}
Number purifyvolume "Purivied Volume" (G_airpurifier) {channel="miio:basic:airpurifier:purifyvolume"}
Switch childlock "Child Lock" (G_airpurifier) {channel="miio:basic:airpurifier:childlock"}
```

### Mi Air Purifier MS2 (zhimi.airpurifier.ma2) item file lines


note: Autogenerated example. Replace the id (airpurifier) in the channel with your own.

```
Group G_airpurifier "Mi Air Purifier MS2" <status>
Switch power "Power" (G_airpurifier) {channel="miio:basic:airpurifier:power"}
String mode "Mode" (G_airpurifier) {channel="miio:basic:airpurifier:mode"}
Number humidity "Humidity" (G_airpurifier) {channel="miio:basic:airpurifier:humidity"}
Number aqi "Air Quality Index" (G_airpurifier) {channel="miio:basic:airpurifier:aqi"}
Number averageaqi "Average Air Quality Index" (G_airpurifier) {channel="miio:basic:airpurifier:averageaqi"}
Switch led "Led Status" (G_airpurifier) {channel="miio:basic:airpurifier:led"}
Number bright "Led Brightness" (G_airpurifier) {channel="miio:basic:airpurifier:bright"}
Number filtermaxlife "Filter Max Life" (G_airpurifier) {channel="miio:basic:airpurifier:filtermaxlife"}
Number filterhours "Filter Hours used" (G_airpurifier) {channel="miio:basic:airpurifier:filterhours"}
Number usedhours "Run Time" (G_airpurifier) {channel="miio:basic:airpurifier:usedhours"}
Number motorspeed "Motor Speed" (G_airpurifier) {channel="miio:basic:airpurifier:motorspeed"}
Number filterlife "Filter  Life" (G_airpurifier) {channel="miio:basic:airpurifier:filterlife"}
Number favoritelevel "Favorite Level" (G_airpurifier) {channel="miio:basic:airpurifier:favoritelevel"}
Number temperature "Temperature" (G_airpurifier) {channel="miio:basic:airpurifier:temperature"}
Number purifyvolume "Purivied Volume" (G_airpurifier) {channel="miio:basic:airpurifier:purifyvolume"}
Switch childlock "Child Lock" (G_airpurifier) {channel="miio:basic:airpurifier:childlock"}
```

### Mi Smart Fan (zhimi.fan.v1) item file lines


note: Autogenerated example. Replace the id (fan) in the channel with your own.

```
Group G_fan "Mi Smart Fan" <status>
Switch power "Power" (G_fan) {channel="miio:basic:fan:power"}
Switch angleEnable "Rotation" (G_fan) {channel="miio:basic:fan:angleEnable"}
Number usedhours "Run Time" (G_fan) {channel="miio:basic:fan:usedhours"}
Number angle "Angle" (G_fan) {channel="miio:basic:fan:angle"}
Number poweroffTime "Timer" (G_fan) {channel="miio:basic:fan:poweroffTime"}
Switch buzzer "Buzzer" (G_fan) {channel="miio:basic:fan:buzzer"}
Number led_b "Led" (G_fan) {channel="miio:basic:fan:led_b"}
Switch child_lock "Child Lock" (G_fan) {channel="miio:basic:fan:child_lock"}
Number speedLevel "Speed Level" (G_fan) {channel="miio:basic:fan:speedLevel"}
Number speed "Speed" (G_fan) {channel="miio:basic:fan:speed"}
Number naturalLevel "Natural Level" (G_fan) {channel="miio:basic:fan:naturalLevel"}
Number temp_dec "Temperature" (G_fan) {channel="miio:basic:fan:temp_dec"}
Number humidity "Humidity" (G_fan) {channel="miio:basic:fan:humidity"}
String acPower "AC Power" (G_fan) {channel="miio:basic:fan:acPower"}
String mode "Battery Charge" (G_fan) {channel="miio:basic:fan:mode"}
Number battery "Battery" (G_fan) {channel="miio:basic:fan:battery"}
String move "Move Direction" (G_fan) {channel="miio:basic:fan:move"}
```

### Mi Smart Fan (zhimi.fan.v2) item file lines


note: Autogenerated example. Replace the id (fan) in the channel with your own.

```
Group G_fan "Mi Smart Fan" <status>
Switch power "Power" (G_fan) {channel="miio:basic:fan:power"}
Switch angleEnable "Rotation" (G_fan) {channel="miio:basic:fan:angleEnable"}
Number usedhours "Run Time" (G_fan) {channel="miio:basic:fan:usedhours"}
Number angle "Angle" (G_fan) {channel="miio:basic:fan:angle"}
Number poweroffTime "Timer" (G_fan) {channel="miio:basic:fan:poweroffTime"}
Switch buzzer "Buzzer" (G_fan) {channel="miio:basic:fan:buzzer"}
Number led_b "Led" (G_fan) {channel="miio:basic:fan:led_b"}
Switch child_lock "Child Lock" (G_fan) {channel="miio:basic:fan:child_lock"}
Number speedLevel "Speed Level" (G_fan) {channel="miio:basic:fan:speedLevel"}
Number speed "Speed" (G_fan) {channel="miio:basic:fan:speed"}
Number naturalLevel "Natural Level" (G_fan) {channel="miio:basic:fan:naturalLevel"}
Number temp_dec "Temperature" (G_fan) {channel="miio:basic:fan:temp_dec"}
Number humidity "Humidity" (G_fan) {channel="miio:basic:fan:humidity"}
String acPower "AC Power" (G_fan) {channel="miio:basic:fan:acPower"}
String mode "Battery Charge" (G_fan) {channel="miio:basic:fan:mode"}
Number battery "Battery" (G_fan) {channel="miio:basic:fan:battery"}
String move "Move Direction" (G_fan) {channel="miio:basic:fan:move"}
```

### Mi Smart Pedestal Fan (zhimi.fan.v3) item file lines


note: Autogenerated example. Replace the id (fan) in the channel with your own.

```
Group G_fan "Mi Smart Pedestal Fan" <status>
Switch power "Power" (G_fan) {channel="miio:basic:fan:power"}
Switch angleEnable "Rotation" (G_fan) {channel="miio:basic:fan:angleEnable"}
Number usedhours "Run Time" (G_fan) {channel="miio:basic:fan:usedhours"}
Number angle "Angle" (G_fan) {channel="miio:basic:fan:angle"}
Number poweroffTime "Timer" (G_fan) {channel="miio:basic:fan:poweroffTime"}
Switch buzzer "Buzzer" (G_fan) {channel="miio:basic:fan:buzzer"}
Number led_b "Led" (G_fan) {channel="miio:basic:fan:led_b"}
Switch child_lock "Child Lock" (G_fan) {channel="miio:basic:fan:child_lock"}
Number speedLevel "Speed Level" (G_fan) {channel="miio:basic:fan:speedLevel"}
Number speed "Speed" (G_fan) {channel="miio:basic:fan:speed"}
Number naturalLevel "Natural Level" (G_fan) {channel="miio:basic:fan:naturalLevel"}
Number temp_dec "Temperature" (G_fan) {channel="miio:basic:fan:temp_dec"}
Number humidity "Humidity" (G_fan) {channel="miio:basic:fan:humidity"}
String acPower "AC Power" (G_fan) {channel="miio:basic:fan:acPower"}
String mode "Battery Charge" (G_fan) {channel="miio:basic:fan:mode"}
Number battery "Battery" (G_fan) {channel="miio:basic:fan:battery"}
String move "Move Direction" (G_fan) {channel="miio:basic:fan:move"}
```

### Xiaomi Mi Smart Pedestal Fan (zhimi.fan.sa1) item file lines


note: Autogenerated example. Replace the id (fan) in the channel with your own.

```
Group G_fan "Xiaomi Mi Smart Pedestal Fan" <status>
Switch power "Power" (G_fan) {channel="miio:basic:fan:power"}
Switch angleEnable "Rotation" (G_fan) {channel="miio:basic:fan:angleEnable"}
Number usedhours "Run Time" (G_fan) {channel="miio:basic:fan:usedhours"}
Number angle "Angle" (G_fan) {channel="miio:basic:fan:angle"}
Number poweroffTime "Timer" (G_fan) {channel="miio:basic:fan:poweroffTime"}
Switch buzzer "Buzzer" (G_fan) {channel="miio:basic:fan:buzzer"}
Number led_b "Led" (G_fan) {channel="miio:basic:fan:led_b"}
Switch child_lock "Child Lock" (G_fan) {channel="miio:basic:fan:child_lock"}
Number speedLevel "Speed Level" (G_fan) {channel="miio:basic:fan:speedLevel"}
Number speed "Speed" (G_fan) {channel="miio:basic:fan:speed"}
Number naturalLevel "Natural Level" (G_fan) {channel="miio:basic:fan:naturalLevel"}
Switch acPower "AC Power" (G_fan) {channel="miio:basic:fan:acPower"}
String move "Move Direction" (G_fan) {channel="miio:basic:fan:move"}
```

### Xiaomi Mi Smart Pedestal Fan (zhimi.fan.za1) item file lines


note: Autogenerated example. Replace the id (fan) in the channel with your own.

```
Group G_fan "Xiaomi Mi Smart Pedestal Fan" <status>
Switch power "Power" (G_fan) {channel="miio:basic:fan:power"}
Switch angleEnable "Rotation" (G_fan) {channel="miio:basic:fan:angleEnable"}
Number usedhours "Run Time" (G_fan) {channel="miio:basic:fan:usedhours"}
Number angle "Angle" (G_fan) {channel="miio:basic:fan:angle"}
Number poweroffTime "Timer" (G_fan) {channel="miio:basic:fan:poweroffTime"}
Switch buzzer "Buzzer" (G_fan) {channel="miio:basic:fan:buzzer"}
Number led_b "Led" (G_fan) {channel="miio:basic:fan:led_b"}
Switch child_lock "Child Lock" (G_fan) {channel="miio:basic:fan:child_lock"}
Number speedLevel "Speed Level" (G_fan) {channel="miio:basic:fan:speedLevel"}
Number speed "Speed" (G_fan) {channel="miio:basic:fan:speed"}
Number naturalLevel "Natural Level" (G_fan) {channel="miio:basic:fan:naturalLevel"}
Switch acPower "AC Power" (G_fan) {channel="miio:basic:fan:acPower"}
String move "Move Direction" (G_fan) {channel="miio:basic:fan:move"}
```

### Mi Humdifier (zhimi.humidifier.v1) item file lines


note: Autogenerated example. Replace the id (humidifier) in the channel with your own.

```
Group G_humidifier "Mi Humdifier" <status>
Switch power "Power" (G_humidifier) {channel="miio:basic:humidifier:power"}
String mode "Mode" (G_humidifier) {channel="miio:basic:humidifier:mode"}
Number humidity "Humidity" (G_humidifier) {channel="miio:basic:humidifier:humidity"}
Number setHumidity "Humidity Set" (G_humidifier) {channel="miio:basic:humidifier:setHumidity"}
Number aqi "Air Quality Index" (G_humidifier) {channel="miio:basic:humidifier:aqi"}
Number translevel "Trans_level" (G_humidifier) {channel="miio:basic:humidifier:translevel"}
Number bright "Led Brightness" (G_humidifier) {channel="miio:basic:humidifier:bright"}
Switch buzzer "Buzzer Status" (G_humidifier) {channel="miio:basic:humidifier:buzzer"}
Number depth "Depth" (G_humidifier) {channel="miio:basic:humidifier:depth"}
Switch dry "Dry" (G_humidifier) {channel="miio:basic:humidifier:dry"}
Number usedhours "Run Time" (G_humidifier) {channel="miio:basic:humidifier:usedhours"}
Number motorspeed "Motor Speed" (G_humidifier) {channel="miio:basic:humidifier:motorspeed"}
Number temperature "Temperature" (G_humidifier) {channel="miio:basic:humidifier:temperature"}
Switch childlock "Child Lock" (G_humidifier) {channel="miio:basic:humidifier:childlock"}
```

### Xiaomi Philips Eyecare Smart Lamp 2 (philips.light.sread1) item file lines


note: Autogenerated example. Replace the id (light) in the channel with your own.

```
Group G_light "Xiaomi Philips Eyecare Smart Lamp 2" <status>
Switch power "Power" (G_light) {channel="miio:basic:light:power"}
Number brightness "Brightness" (G_light) {channel="miio:basic:light:brightness"}
Switch ambientPower "Ambient Power" (G_light) {channel="miio:basic:light:ambientPower"}
Number ambientBrightness "Ambient Brightness" (G_light) {channel="miio:basic:light:ambientBrightness"}
Number illumination "Ambient Illumination" (G_light) {channel="miio:basic:light:illumination"}
Switch eyecare "Eyecare" (G_light) {channel="miio:basic:light:eyecare"}
```

### Xiaomi Philips LED Ceiling Lamp (philips.light.ceiling) item file lines


note: Autogenerated example. Replace the id (light) in the channel with your own.

```
Group G_light "Xiaomi Philips LED Ceiling Lamp" <status>
Switch power "Power" (G_light) {channel="miio:basic:light:power"}
Number brightness "Brightness" (G_light) {channel="miio:basic:light:brightness"}
Number cct "Correlated Color Temperature" (G_light) {channel="miio:basic:light:cct"}
Number scene "Scene" (G_light) {channel="miio:basic:light:scene"}
Switch switchscene "Switch Scene" (G_light) {channel="miio:basic:light:switchscene"}
Switch toggle "Toggle" (G_light) {channel="miio:basic:light:toggle"}
```

### Xiaomi Philips LED Ceiling Lamp (philips.light.zyceiling) item file lines


note: Autogenerated example. Replace the id (light) in the channel with your own.

```
Group G_light "Xiaomi Philips LED Ceiling Lamp" <status>
Switch power "Power" (G_light) {channel="miio:basic:light:power"}
Number brightness "Brightness" (G_light) {channel="miio:basic:light:brightness"}
Number cct "Correlated Color Temperature" (G_light) {channel="miio:basic:light:cct"}
Number scene "Scene" (G_light) {channel="miio:basic:light:scene"}
Switch switchscene "Switch Scene" (G_light) {channel="miio:basic:light:switchscene"}
Switch toggle "Toggle" (G_light) {channel="miio:basic:light:toggle"}
```

### Xiaomi Philips Bulb (philips.light.bulb) item file lines


note: Autogenerated example. Replace the id (light) in the channel with your own.

```
Group G_light "Xiaomi Philips Bulb" <status>
Switch power "Power" (G_light) {channel="miio:basic:light:power"}
Number brightness "Brightness" (G_light) {channel="miio:basic:light:brightness"}
Number cct "Correlated Color Temperature" (G_light) {channel="miio:basic:light:cct"}
Number scene "Scene" (G_light) {channel="miio:basic:light:scene"}
Number dv "DV" (G_light) {channel="miio:basic:light:dv"}
Switch switchscene "Switch Scene" (G_light) {channel="miio:basic:light:switchscene"}
Switch delayoff "Delay Off" (G_light) {channel="miio:basic:light:delayoff"}
Switch toggle "Toggle" (G_light) {channel="miio:basic:light:toggle"}
```

### Xiaomi Philips Downlight (philips.light.downlight) item file lines


note: Autogenerated example. Replace the id (light) in the channel with your own.

```
Group G_light "Xiaomi Philips Downlight" <status>
Switch power "Power" (G_light) {channel="miio:basic:light:power"}
Number brightness "Brightness" (G_light) {channel="miio:basic:light:brightness"}
Number cct "Correlated Color Temperature" (G_light) {channel="miio:basic:light:cct"}
Number scene "Scene" (G_light) {channel="miio:basic:light:scene"}
Number dv "DV" (G_light) {channel="miio:basic:light:dv"}
Switch switchscene "Switch Scene" (G_light) {channel="miio:basic:light:switchscene"}
Switch delayoff "Delay Off" (G_light) {channel="miio:basic:light:delayoff"}
Switch toggle "Toggle" (G_light) {channel="miio:basic:light:toggle"}
```

### Mi Power-plug (chuangmi.plug.m1) item file lines


note: Autogenerated example. Replace the id (plug) in the channel with your own.

```
Group G_plug "Mi Power-plug" <status>
Switch power "Power" (G_plug) {channel="miio:basic:plug:power"}
Number temperature "Temperature" (G_plug) {channel="miio:basic:plug:temperature"}
```

### Mi Power-plug v1 (chuangmi.plug.v1) item file lines


note: Autogenerated example. Replace the id (plug) in the channel with your own.

```
Group G_plug "Mi Power-plug v1" <status>
Switch power "Power" (G_plug) {channel="miio:basic:plug:power"}
OnOffType usb "USB" (G_plug) {channel="miio:basic:plug:usb"}
```

### Mi Power-plug v2 (chuangmi.plug.v2) item file lines


note: Autogenerated example. Replace the id (plug) in the channel with your own.

```
Group G_plug "Mi Power-plug v2" <status>
Switch power "Power" (G_plug) {channel="miio:basic:plug:power"}
OnOffType usb "USB" (G_plug) {channel="miio:basic:plug:usb"}
```

### Mi Power-plug v3 (chuangmi.plug.v3) item file lines


note: Autogenerated example. Replace the id (plug) in the channel with your own.

```
Group G_plug "Mi Power-plug v3" <status>
Switch power "Power" (G_plug) {channel="miio:basic:plug:power"}
OnOffType usb "USB" (G_plug) {channel="miio:basic:plug:usb"}
Number temperature "Temperature" (G_plug) {channel="miio:basic:plug:temperature"}
Switch led "Wifi led" (G_plug) {channel="miio:basic:plug:led"}
```

### Qing Mi Smart Power Strip v1 (qmi.powerstrip.v1) item file lines


note: Autogenerated example. Replace the id (powerstrip) in the channel with your own.

```
Group G_powerstrip "Qing Mi Smart Power Strip v1" <status>
Switch power "Power" (G_powerstrip) {channel="miio:basic:powerstrip:power"}
Number powerUsage "Power Consumption" (G_powerstrip) {channel="miio:basic:powerstrip:powerUsage"}
Switch led "wifi_led" (G_powerstrip) {channel="miio:basic:powerstrip:led"}
Number power_price "power_price" (G_powerstrip) {channel="miio:basic:powerstrip:power_price"}
Number current "Current" (G_powerstrip) {channel="miio:basic:powerstrip:current"}
Number temperature "Temperature" (G_powerstrip) {channel="miio:basic:powerstrip:temperature"}
```

### Mi Power-strip v2 (zimi.powerstrip.v2) item file lines


note: Autogenerated example. Replace the id (powerstrip) in the channel with your own.

```
Group G_powerstrip "Mi Power-strip v2" <status>
Switch power "Power" (G_powerstrip) {channel="miio:basic:powerstrip:power"}
Number powerUsage "Power Consumption" (G_powerstrip) {channel="miio:basic:powerstrip:powerUsage"}
Switch led "wifi_led" (G_powerstrip) {channel="miio:basic:powerstrip:led"}
Number power_price "power_price" (G_powerstrip) {channel="miio:basic:powerstrip:power_price"}
Number current "Current" (G_powerstrip) {channel="miio:basic:powerstrip:current"}
Number temperature "Temperature" (G_powerstrip) {channel="miio:basic:powerstrip:temperature"}
```

### Mi Water Purifier v2 (yunmi.waterpuri.v2) item file lines


note: Autogenerated example. Replace the id (waterpuri) in the channel with your own.

```
Group G_waterpuri "Mi Water Purifier v2" <status>
Switch power "Power" (G_waterpuri) {channel="miio:basic:waterpuri:power"}
```

### Yeelight Lamp (yeelink.light.bslamp1) item file lines


note: Autogenerated example. Replace the id (light) in the channel with your own.

```
Group G_light "Yeelight Lamp" <status>
Switch power "Power" (G_light) {channel="miio:basic:light:power"}
Number brightness "Brightness" (G_light) {channel="miio:basic:light:brightness"}
Number delayoff "delayoff" (G_light) {channel="miio:basic:light:delayoff"}
Number colorTemperature "Color Temperature" (G_light) {channel="miio:basic:light:colorTemperature"}
Number colorMode "colorMode" (G_light) {channel="miio:basic:light:colorMode"}
String name "Name" (G_light) {channel="miio:basic:light:name"}
```

### Yeelight Color Bulb (yeelink.light.color1) item file lines


note: Autogenerated example. Replace the id (light) in the channel with your own.

```
Group G_light "Yeelight Color Bulb" <status>
Switch power "Power" (G_light) {channel="miio:basic:light:power"}
Number brightness "Brightness" (G_light) {channel="miio:basic:light:brightness"}
String delayoff "delayoff" (G_light) {channel="miio:basic:light:delayoff"}
Number colorTemperature "Color Temperature" (G_light) {channel="miio:basic:light:colorTemperature"}
String colorMode "colorMode" (G_light) {channel="miio:basic:light:colorMode"}
Switch toggle "toggle" (G_light) {channel="miio:basic:light:toggle"}
Color color "color" (G_light) {channel="miio:basic:light:color"}
String name "Name" (G_light) {channel="miio:basic:light:name"}
```

### Yeelight Color Bulb YLDP06YL 10W (yeelink.light.color2) item file lines


note: Autogenerated example. Replace the id (light) in the channel with your own.

```
Group G_light "Yeelight Color Bulb YLDP06YL 10W" <status>
Switch power "Power" (G_light) {channel="miio:basic:light:power"}
Number brightness "Brightness" (G_light) {channel="miio:basic:light:brightness"}
String delayoff "delayoff" (G_light) {channel="miio:basic:light:delayoff"}
Number colorTemperature "Color Temperature" (G_light) {channel="miio:basic:light:colorTemperature"}
String colorMode "colorMode" (G_light) {channel="miio:basic:light:colorMode"}
Switch toggle "toggle" (G_light) {channel="miio:basic:light:toggle"}
Color color "color" (G_light) {channel="miio:basic:light:color"}
String name "Name" (G_light) {channel="miio:basic:light:name"}
```

### Yeelight LED Ceiling Lamp (yeelink.light.ceiling1) item file lines


note: Autogenerated example. Replace the id (light) in the channel with your own.

```
Group G_light "Yeelight LED Ceiling Lamp" <status>
Switch power "Power" (G_light) {channel="miio:basic:light:power"}
Number brightness "Brightness" (G_light) {channel="miio:basic:light:brightness"}
Number delayoff "delayoff" (G_light) {channel="miio:basic:light:delayoff"}
Number colorTemperature "Color Temperature" (G_light) {channel="miio:basic:light:colorTemperature"}
Number colorMode "colorMode" (G_light) {channel="miio:basic:light:colorMode"}
String name "Name" (G_light) {channel="miio:basic:light:name"}
```

### Yeelight LED Ceiling Lamp v2 (yeelink.light.ceiling2) item file lines


note: Autogenerated example. Replace the id (light) in the channel with your own.

```
Group G_light "Yeelight LED Ceiling Lamp v2" <status>
Switch power "Power" (G_light) {channel="miio:basic:light:power"}
Number brightness "Brightness" (G_light) {channel="miio:basic:light:brightness"}
Number delayoff "delayoff" (G_light) {channel="miio:basic:light:delayoff"}
Number colorTemperature "Color Temperature" (G_light) {channel="miio:basic:light:colorTemperature"}
Number colorMode "colorMode" (G_light) {channel="miio:basic:light:colorMode"}
String name "Name" (G_light) {channel="miio:basic:light:name"}
```

### Yeelight LED Ceiling Lamp v3 (yeelink.light.ceiling3) item file lines


note: Autogenerated example. Replace the id (light) in the channel with your own.

```
Group G_light "Yeelight LED Ceiling Lamp v3" <status>
Switch power "Power" (G_light) {channel="miio:basic:light:power"}
Number brightness "Brightness" (G_light) {channel="miio:basic:light:brightness"}
Number delayoff "delayoff" (G_light) {channel="miio:basic:light:delayoff"}
Number colorTemperature "Color Temperature" (G_light) {channel="miio:basic:light:colorTemperature"}
Number colorMode "colorMode" (G_light) {channel="miio:basic:light:colorMode"}
String name "Name" (G_light) {channel="miio:basic:light:name"}
```

### Yeelight LED Ceiling Lamp v4 (JIAOYUE 650 RGB) (yeelink.light.ceiling4) item file lines


note: Autogenerated example. Replace the id (light) in the channel with your own.

```
Group G_light "Yeelight LED Ceiling Lamp v4 (JIAOYUE 650 RGB)" <status>
Switch power "Power" (G_light) {channel="miio:basic:light:power"}
Number brightness "Brightness" (G_light) {channel="miio:basic:light:brightness"}
Number ambientBrightness "Ambient Brightness" (G_light) {channel="miio:basic:light:ambientBrightness"}
Number delayoff "delayoff" (G_light) {channel="miio:basic:light:delayoff"}
Number colorTemperature "Color Temperature" (G_light) {channel="miio:basic:light:colorTemperature"}
Number colorMode "Color Mode" (G_light) {channel="miio:basic:light:colorMode"}
String name "Name" (G_light) {channel="miio:basic:light:name"}
Switch ambientPower "Ambient Power" (G_light) {channel="miio:basic:light:ambientPower"}
Color ambientColor "Ambient Color" (G_light) {channel="miio:basic:light:ambientColor"}
Number ambientColorTemperature "Ambient Color Temperature" (G_light) {channel="miio:basic:light:ambientColorTemperature"}
String customScene "Set Scene" (G_light) {channel="miio:basic:light:customScene"}
Number ambientColorMode "Ambient Color Mode" (G_light) {channel="miio:basic:light:ambientColorMode"}
Number nightlightBrightness "Nightlight Brightness" (G_light) {channel="miio:basic:light:nightlightBrightness"}
```

### Yeelight (yeelink.light.lamp1) item file lines


note: Autogenerated example. Replace the id (light) in the channel with your own.

```
Group G_light "Yeelight" <status>
Switch power "Power" (G_light) {channel="miio:basic:light:power"}
Number brightness "Brightness" (G_light) {channel="miio:basic:light:brightness"}
Number delayoff "delayoff" (G_light) {channel="miio:basic:light:delayoff"}
Number colorTemperature "Color Temperature" (G_light) {channel="miio:basic:light:colorTemperature"}
Number colorMode "colorMode" (G_light) {channel="miio:basic:light:colorMode"}
String name "Name" (G_light) {channel="miio:basic:light:name"}
```

### Yeelight White Bulb (yeelink.light.mono1) item file lines


note: Autogenerated example. Replace the id (light) in the channel with your own.

```
Group G_light "Yeelight White Bulb" <status>
Switch power "Power" (G_light) {channel="miio:basic:light:power"}
Number brightness "Brightness" (G_light) {channel="miio:basic:light:brightness"}
Number delayoff "delayoff" (G_light) {channel="miio:basic:light:delayoff"}
Number colorTemperature "Color Temperature" (G_light) {channel="miio:basic:light:colorTemperature"}
Number colorMode "colorMode" (G_light) {channel="miio:basic:light:colorMode"}
String name "Name" (G_light) {channel="miio:basic:light:name"}
```

### Yeelight White Bulb v2 (yeelink.light.mono2) item file lines


note: Autogenerated example. Replace the id (light) in the channel with your own.

```
Group G_light "Yeelight White Bulb v2" <status>
Switch power "Power" (G_light) {channel="miio:basic:light:power"}
Number brightness "Brightness" (G_light) {channel="miio:basic:light:brightness"}
Number delayoff "delayoff" (G_light) {channel="miio:basic:light:delayoff"}
Number colorTemperature "Color Temperature" (G_light) {channel="miio:basic:light:colorTemperature"}
Number colorMode "colorMode" (G_light) {channel="miio:basic:light:colorMode"}
String name "Name" (G_light) {channel="miio:basic:light:name"}
```

### Yeelight Strip (yeelink.light.strip1) item file lines


note: Autogenerated example. Replace the id (light) in the channel with your own.

```
Group G_light "Yeelight Strip" <status>
Switch power "Power" (G_light) {channel="miio:basic:light:power"}
Number brightness "Brightness" (G_light) {channel="miio:basic:light:brightness"}
Number delayoff "delayoff" (G_light) {channel="miio:basic:light:delayoff"}
Number colorTemperature "Color Temperature" (G_light) {channel="miio:basic:light:colorTemperature"}
Number colorMode "colorMode" (G_light) {channel="miio:basic:light:colorMode"}
String name "Name" (G_light) {channel="miio:basic:light:name"}
```

### Xiaomi Gateway (lumi.gateway.v3) item file lines

**xiaomi.things**:
```
Thing miio:gateway:<device id> "Xiaomi Gateway"  [ token="<your token>", host="<yout gateway ip>", refreshInterval=60, deviceId="<device id>", model="lumi.gateway.v3" ]
```

**xiaomi.items**:
```
Color   Xiaomi_Gateway_color                    "Base color"                    {channel="miio:gateway:<device id>:led#color"}
Color   Xiaomi_Gateway_night_light_color        "Night light color"             {channel="miio:gateway:<device id>:led#nightLightColor"}
Number  Xiaomi_Gateway_illumination             "Ilumination [ %d lx]"          {channel="miio:gateway:<device id>:led#illumination"}

Dimmer  Xiaomi_Gateway_volume_alarming          "Alarm volume"                  {channel="miio:gateway:<device id>:volume#alarming"}
Dimmer  Xiaomi_Gateway_volume_gateway           "Gateway volume"                {channel="miio:gateway:<device id>:volume#gateway"}
Dimmer  Xiaomi_Gateway_volume_doorbell          "Doorbell volume"               {channel="miio:gateway:<device id>:volume#doorbell"}
Dimmer  Xiaomi_Gateway_volume_fm                "Fm volume"                     {channel="miio:gateway:<device id>:volume#fm"}
```

**xiaomi.sitemap**:
```
sitemap xiaomi_test label="Xiaomi gateway testsite" {
        Frame label="Leds" {
                Colorpicker item=Xiaomi_Gateway_color 
                Colorpicker item=Xiaomi_Gateway_night_light_color 

                Text item=Xiaomi_Gateway_illumination
        }
        Frame label="Volumes" {
                Slider item=Xiaomi_Gateway_volume_alarming   icon="soundvolume" 
                Slider item=Xiaomi_Gateway_volume_gateway    icon="soundvolume" 
                Slider item=Xiaomi_Gateway_volume_doorbell   icon="soundvolume"
                Slider item=Xiaomi_Gateway_volume_fm         icon="soundvolume" 
        }
}
```
