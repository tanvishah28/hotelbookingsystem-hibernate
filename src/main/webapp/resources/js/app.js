// creating object of http class
const http = new Http();

// creating constant variables to get HTML elements - # for id & . for class
const submitForm = document.getElementById('formId');
const nameInput = document.querySelector('#name');
const locationInput = document.getElementById('location');
const phoneInput = document.querySelector('#phone');
const emailInput = document.querySelector('#email');
const ratingInput = document.querySelector('#rating');
const petFriendlyInput = document.querySelector('#pet-friendly');

console.log("nameInput element ", nameInput);
console.log("locationInput element ", locationInput);
console.log("Submit form element ", submitForm);

// to prevent refresh of submit event
submitForm.addEventListener('submit', (event) => {
	event.preventDefault();
	console.log("Event Prevented");
});

// creating function for calling delete() using http object
async function deleteHotel(url) {
	console.log("Delete link clicked");
	console.log("Delete URL " + url);
	const response = await http.delete(url);
	console.log("Inside app.js delete ", response);
}

// creating function for calling edit() using http object
async function editHotel(url) {
	// creating hotel object by using value property of html element
	const hotel = {	
		"hotel_name": nameInput.value,
		"hotel_location": locationInput.value,
		"hotel_phone": phoneInput.value,
		"hotel_email": emailInput.value,
		"hotel_rating": ratingInput.value,
		"pet_friendly": petFriendlyInput.value,
	};
	console.log('Edit link clicked');
	console.log('Edit URL ' + url);
	console.log('Edit Hotel ' + hotel);
	// calling http put() 
	const response = await http.put(url, hotel);
	console.log('Inside app.js edit ', response);
//	return response;
}



