 sidebarShow = () =>{
    console.log("Evento: show sidebar");
    document.getElementsByClassName("sidebar")[0].style.display="block";
}

sidebarHide = () =>{
    console.log("Evento: hide sidebar");
    document.getElementsByClassName("sidebar")[0].style.display="none";
}

sidebarHandler = () =>{
    let sidebarStatus = document.getElementsByClassName(
        "sidebar"
    )[0].style.display;
    
    if (sidebarStatus == "block"){
        sidebarHide();
        return;
    }else{
        sidebarShow();
        return;
    }

}