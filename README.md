This is an exceedingly simple android application that displays the file stored in '/sdcard/My Files/sync/weather.png'
When the scrren is tapped, it displays the file '/sdcard/My Files/sync/train.png'

After a few minutes of inactivity, it goes back to displaying weather.png

It also refreshes the screen every 5 minutes with the current version of '/sdcard/My Files/sync/weather.png'

I wrote this app to be used on a B&N Nook Simple Touch that's been rooted to run arbitrary android apps. This application is designed to be run in conjunction with a server that runs the [eink-weather-display](https://github.com/zeronickname/eink-weather-display) script which will generate the weather.png file. 


A pre-compiled apk [can be found here](https://github.com/zeronickname/WeatherShow/tree/master/bin) (if you don't want to compile the application yourself)
