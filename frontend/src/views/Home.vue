<template>
  <div class="home" align="center">
    <h1>Customer List</h1>
    <!-- <a href="/new">Create New Customer</a> -->
    <router-link to="/customer-new">Create New Customer</router-link>
    <br />
    <table border="1" cellpadding="10">
      <thead>
        <tr>
          <th>Customer ID</th>
          <th>First Name</th>
          <th>Last Name</th>
        </tr>
      </thead>
      <tbody v-if="!isLoading">
        <tr v-for="customer in customers" :key="customer.id">
          <td>{{ customer.id }}</td>
          <td>{{ customer.firstName }}</td>
          <td>{{ customer.lastName }}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import CustomerDataService from "../services/CustomerDataService";

export default {
  name: "Home",
  data() {
    return {
      customers: [],
      isLoading: false
    };
  },
  methods: {
    getCustomers() {
      this.isLoading = true;
      CustomerDataService.getAll()
        .then(response => {
          this.customers = response.data;
          this.isLoading = false;
        })
        .catch(e => {
          console.log(e);
        });
    }
  },
  created() {
    this.getCustomers();
  }
};
</script>
