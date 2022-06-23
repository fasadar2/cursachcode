import axios from 'axios';
export default {
  data: () => ({
    loading: true,
  }),
  methods: {
    GetList() {
      const config = {
        url: 'http://localhost:8081/greet/{name}',
      };
      axios.get(config.url)
        .then((response) => {
          console.log(response.data);
        })
        .catch((error) => {
          console.log(error);
        });
    },

},}
