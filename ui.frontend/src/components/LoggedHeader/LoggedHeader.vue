<template>
  <header>
    <img :src="pageLogo"/>
    <div class="clock"><DateClock/></div>
    <div class="weather"><Weather/></div>
  </header>
</template>

<script>
import DateClock from '../DateClock/DateClock'
import Weather from '../Weather/Weather'
export default {
  name: 'LoggedHeader',
  components: {
    DateClock,
    Weather
  },
  props: {
    pageLogo: {
      type: String
    }
  }
}
</script>

<style lang="scss" scoped>
@import "./logged-header.scss";
</style>
