export function auth(formData) {
    return new Promise((resolve, reject) => {
      return fetch('https://health-application.cfapps.io/login', {
        method: "POST",
        mode: "cors",
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(formData)
      })
        .then(function (response) {
          return response.json();
        })
        .then(function (response) {
          resolve(response);
        })
    })
  }