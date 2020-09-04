<template>
  <div align="center">
    <div v-if="!submitted">
      <h1>Create New Customer</h1>
      <br />
      <table border="0" cellpadding="10">
        <tr>
          <td>First Name:</td>
          <td>
            <input type="text" v-model="customer.firstName" />
          </td>
        </tr>
        <tr>
          <td>Last Name:</td>
          <td>
            <input type="text" v-model="customer.lastName" />
          </td>
        </tr>
        <tr>
          <td colspan="2">
            <button @click="saveCustomer">Save</button>
          </td>
        </tr>
      </table>
    </div>
    <div v-else>
      <h4>You submitted successfully!</h4>
      <button @click="newCustomer">Add</button>
    </div>
  </div>
</template>

<script>
import CustomerDataService from "../services/CustomerDataService";

export default {
  data() {
    return {
      customer: {
        firstName: "",
        lastName: ""
      },
      submitted: false
    };
  },
  methods: {
    saveCustomer() {
      CustomerDataService.create(this.customer)
        .then(response => {
          this.customer.id = response.data.id;
          this.submitted = true;
        })
        .catch(e => {
          console.log(e);
        });
    },

    newCustomer() {
      this.submitted = false;
      this.customer = {};
    }
  }
};
</script>
