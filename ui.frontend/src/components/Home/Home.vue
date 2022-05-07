<template>
  <div id="homeContainer">
    <img src="/content/dam/vue/uol-ball-transparent.png"/>
    <div class="main-text">
      <div v-for="(item, index) in items" :key="index">
        <p :class="{'en-text': true, 'first': index === 0}">{{item.en}}</p>
        <p class="pt-text">{{item.pt}}</p>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Home',
  props: {
    items: {
      type: Array
    }
  },
  methods: {
    getAuthUser () {
      // <p>{{this.getAuthUser()}}</p>
      return localStorage.getItem('user')
    }
  }
}
</script>

<style lang="scss">
@import "./home.scss";
</style>
