import axios from '../axios';

/*
CURRENTLY: (using 3000 for CORS-testing untill gateway is finished)
    3000 = user
    3001 = posts
    3002 = UI
    8080 = gateway
*/

const axios = axios.create({
    baseURL: 'http://localhost:3000'
});

export default axios;