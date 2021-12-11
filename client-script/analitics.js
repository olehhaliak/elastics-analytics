/**************************************************************/
/* connect this script to page you want to get analytics from */
/**************************************************************/

async function postData(url = '', data = {}) {
    const response = await fetch(url, {
        method: 'POST',
        mode: 'cors',
        cache: 'no-cache',
        credentials: 'same-origin',
        headers: {
            'Content-Type': 'application/json'
        },
        redirect: 'follow',
        referrerPolicy: 'no-referrer',
        body: JSON.stringify(data)
    });
    return await response.json();
}

var dev_info = {};
dev_info.page = window.location.pathname;
dev_info.referer = document.referrer;
dev_info.historyLength = history.length;
dev_info.locale = navigator.language;
dev_info.platform = window.navigator.userAgent;
dev_info.layout = {};
dev_info.layout.screenWidth = screen.width;
dev_info.layout.screenHeight = screen.height;
dev_info.layout.windowWidth = innerWidth;
dev_info.layout.windowHeight = innerHeight;
dev_info.clientTime = {};
dev_info.clientTime.timestamp = Date.now();
dev_info.clientTime.timezone = new Date().getTimezoneOffset() / -60;
postData('http://localhost:8080/analytics/', dev_info);