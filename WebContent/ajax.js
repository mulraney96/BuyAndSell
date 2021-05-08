/**
 * 
 */
var xhttp


function init(){
	fillTable(null);
};

function fillTable(){
	xhttp = new XMLHttpRequest();
	var search = document.getElementById("search").value;
	
	const url="/BuyAndSell/HomeServlet?SearchString="+search;
	console.log();
	xhttp.open("POST", url);
	xhttp.send();

	xhttp.onreadystatechange=(e) = function() {
		if(this.readyState==4 && this.status==200){
				document.getElementById("itemList").innerHTML=xhttp.responseText;
			}
		}
	};
	
function placeBid(id, buttonId){
	xhttp = new XMLHttpRequest();
	var bid = document.getElementById(buttonId).value;
	const url="/BuyAndSell/BidServlet?ItemId="+id+"&PlaceBid="+bid;
	console.log();
	xhttp.open("POST", url);
	xhttp.send();

	xhttp.onreadystatechange=(e) = function() {
		if(this.readyState==4 && this.status==200){
				document.getElementById("bidResponse").innerHTML=xhttp.responseText;
			}
		}
	};
	
function logIn(){
	xhttp = new XMLHttpRequest();
	var email = document.getElementById("email").value;
	var password = document.getElementById("password").value;

	const url="/BuyAndSell/LoginServlet?email="+email+"&password="+password;
	xhttp.open("POST", url);
	xhttp.send();

	xhttp.onreadystatechange=(e) = function() {
		if(this.readyState==4 && this.status==200){
			    window.location.href = "home.jsp";
		}
		else if(this.status==400)
			document.getElementById("error").innerHTML="email and password incorrect";
			console.log("i am here");
	}

};