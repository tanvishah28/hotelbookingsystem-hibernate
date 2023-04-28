class Http {
	
	// delete()
	async delete(url) {
		const response = await fetch(url, {
			method: 'DELETE'
		});
		console.log("Inside http delete ", response);
		return "Deleted";
	}

	// awaiting fetch which contains methods, content-type & body
	async put(url, hotel) {
		console.log('The JSON hotel object is ', hotel);
		console.log("JSON Hotel object : ",JSON.stringify(hotel));
		const response = await fetch(url, {
			method: 'PUT',
			headers: {
				'Content-type': 'application/json',
			},
			body: JSON.stringify(hotel),
		});
		console.log("Inside http edit ", response);
		// return response data
		return response;
	}
}