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
var botao = document.getElementsByClassName('search-button')[0];
var input = document.getElementsByClassName('search-field')[0];

function pesquisar(){
        let busca = input.value;
        location.href = '/buscar?s='+busca;
        return false;
};
    


input.addEventListener('keyup', function(e){
  var key = e.which || e.keyCode;
  if (key == 13) { // codigo da tecla enter
    pesquisar();
  }
});
botao.onclick = function() {
      pesquisar();
    };