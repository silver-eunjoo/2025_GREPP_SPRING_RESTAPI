const SEQUENCE_KEY = "GREPP_API_EXP_APP_SEQUENCE";

function validate() {
    if(getSequence() === 0){
        alert('게시글을 먼저 작성해주시기 바랍니다.');
        return false;
    }
    return true;
}

function refresh(title, contents, actor) {
    if(title !== null) {
        document.getElementById("title").innerText = title;
    }
    if(actor !== null) {
        document.getElementById("actor").innerText = actor;
    }
    if(contents !== null) {
        document.getElementById("contents").innerText = contents;
    }
}

function getPostValues() {
    return  {
        title : document.getElementById("post-title").value,
        contents : document.getElementById("post-contents").value,
        actor : document.getElementById("post-actor").value
    }
}

function getPatchValues() {
    return {
        title : document.getElementById("patch-title").value,
        contents : document.getElementById("patch-contents").value
    }
}

function clearPostBody() {
    document.getElementById("post-title").value = '';
    document.getElementById("post-contents").value = '';
    document.getElementById("post-actor").value = '';
}

function clearPatchBody() {
    document.getElementById("patch-title").value = '';
    document.getElementById("patch-contents").value = '';
}

function init() {
    window.localStorage.setItem(SEQUENCE_KEY, 0);
}

function getSequence() {
    return parseInt(window.localStorage.getItem(SEQUENCE_KEY));
}

function updateSequence(sequence) {
    window.localStorage.setItem(SEQUENCE_KEY, sequence);
}

function syncSequence() {
    updateSequence(getSequence()-1);
}

init();