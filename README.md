# ConsoleApplicationTime

This console application display greetin message, message`s content depends from user locale and time when program running.

If program runs when time is between :
- [6 a.m. - 9 a.m.) - returns morning`s greeting message;
- [9 a.m. - 19 p.m.) - returns day`s greeting message;
- [19 p.m. - 23 p.m.) - returns evening`s greeting message;
- [23 p.m. - 23.59.59.999 p.m.)  - returns night`s greeting message;
- [0 a.m. - 6 a.m.)  - returns night`s greeting message.

Greeting messages in  MessagesBundles files for Ukrainian and Russian languages was converted to <b>ASCII</b> encoding with <b>Interactive native2ascii</b> (http://native2ascii.net/).

Program generate log file - <b>consoleApp.log</b> .
