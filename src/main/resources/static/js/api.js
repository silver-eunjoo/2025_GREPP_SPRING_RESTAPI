
function createMovie() {

    const data = getPostValues();

    fetch("http://localhost:8080/movies", {
        method : "POST",
        headers : {
            "Content-type" : "application/json"
        },
        body : JSON.stringify(data)
    }).then (
        resp => resp.json()
    ).then(
        data => {
            console.log(data);
            updateSequence(data);
            alert('영화 등록 완료!')
            clearPostBody();
        }
    ).catch(
        err => console.log(err)
    )
}

function getMovie() {
    // http://localhost:8080/movies/{movieId}

    if(!validate()) {
        return ;
    }

    fetch(`http://localhost:8080/movies/${getSequence()}`)
        .then(resp => resp.json())
        .then(data => {
            refresh(
                data.title,
                data.contents,
                data.actor
            );
            alert('가장 최신 영화로 데이터 갱신!');
        })
        .catch(
            err => {
                alert('에러 발생')
                console.log(err)
            }
        )

}

function updateMovie() {

    if(!validate()) {
        return;
    }

    const data = getPatchValues();

    fetch(`http://localhost:8080/movies/${getSequence()}`, {
        method: "PATCH",
        headers: {
            "Content-type" : "application/json"
        },
        body : JSON.stringify(data)
    }).then(
        resp => resp.json()
    ).then(
        data => {
            console.log(data)
            refresh(
                data.title,
                data.contents,
                data.actor
            );
            alert('영화 수정 완료!')
            clearPatchBody();
        }
    ).catch(
        err => {
            console.log(err)
            alert('에러 발생!')
        }
    )
}

function removeMovie() {
    if(!validate()) {
        return ;
    }

    fetch(`http://localhost:8080/movies/${getSequence()}`, {
        method : "DELETE"
    })
        .then(resp => {
            console.log(resp);
            if(resp.status == 204){
                refresh('Title', 'Contents', 'Actor')
                syncSequence();
                alert('마지막 글이 삭제되었습니다!')
            }
        }).catch(
            err => {
                console.log(err)
                alert('에러 발생')
            }
    )
}