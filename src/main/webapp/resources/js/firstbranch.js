function getTime(){
	const date = new Date();
	const second = date.getSeconds();
	const minutes = date.getMinutes();
	const hours = date.getHours();
	
	var timer = document.querySelector('#timer');
	
	timer.innerText = `The time on the server is ${hours < 10 ? `0${hours}` : `${hours}`}:${minutes < 10 ? `0${minutes}` : `${minutes}`}:${second < 10 ? `0${second}` : `${second}`}`;
	
}

function init(){
	getTime();
	setInterval(getTime, 1000);
};

init();