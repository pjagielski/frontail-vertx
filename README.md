# frontail – tail -F output in browser

```frontail``` is vert.x application for serving `tail -f` output to browser.

## Features

* search
* log rotation
* autoscrolling
* marking logs

## Running

    gradle runMod -Dfile=xxx

Web interface is on http://localhost:9090

Running as normal user may not allow you to read some log file, it's useful then to ```tee``` log file with sudo, eg:

    sudo tail -f /var/log/apache2/access.log | tee tail.log
  

## Screenshot

![screenshot1](http://dl.dropbox.com/u/3101412/frontail3.png)

## License

(The MIT License)

Copyright 2013 
Maciej Winnicki http://maciejwinnicki.pl
Piotr Jagielski http://jagielu.com

This project is free software released under the MIT/X11 license:

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
