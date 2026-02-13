const BASE_URI = "http://localhost:3000";
const REFRESH_RATE_MS = 3000;

async function getSolarpanels() {
    const resp = await fetch(BASE_URI+"/station/status");

    if(resp.ok) {
        const json = await resp.json();
        console.log(json);

        const totalpanels = json.power.solar.panels;
        const totalpanelslenght = json.power.solar.panels.length;
        console.log(totalpanels);

        let activecount = 0;
        for(const panel of totalpanels) {
            if(panel.status === "nominal"){
                activecount ++;
            }
        }

        const percentage = (activecount / totalpanelslenght) * 100;

        console.log(percentage);

        return {
            totalpanels : totalpanels,
            operationals : activecount,
            percentage : percentage
        }
    }
}

async function startstationmonitor(){
    console.clear;

    console.log("--- results task 1 ---")
    let task1res = await getSolarpanels()
    console.log(task1res.totalpanels);
    console.log("Operational: "+task1res.operationals);
    console.log("%Operational: "+task1res.percentage);
}

async function getModuls() {
    const resp = await fetch(BASE_URI+"/station/modules");

    if(resp.ok) {
        const json = await resp.json();
        console.log(json);

        const totalmodules = json.modules;
        
        let arrayModules = [];
        for(const module of totalmodules) {
            if(module.status === "nominal"){
                arrayModules.push(module);
            }
        }
        console.log(arrayModules);
    }
}

getModuls();

//setInterval(startstationmonitor, REFRESH_RATE_MS);