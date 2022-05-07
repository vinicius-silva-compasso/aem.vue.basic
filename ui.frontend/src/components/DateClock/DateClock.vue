<template>
  <div id="clock">
    <p class="hour">{{hourText}}</p>
    <p class="date">{{dateText}}</p>
  </div>
</template>

<script>
export default {
  name: 'DateClock',
  data () {
    return {
      hourText: '',
      dateText: ''
    }
  },
  methods: {
    updateClockText () {
      const today = new Date()
      this.hourText = (today.getHours() < 10 ? '0' : '') + today.getHours() + ':' + (today.getMinutes() < 10 ? '0' : '') + today.getMinutes()
      const options = { weekday: 'long', year: 'numeric', month: 'long', day: 'numeric' }
      this.dateText = today.toLocaleDateString('pt-br', options)
    }
  },
  created () {
    setInterval(this.updateClockText, 1000)
  }
}
</script>

<style lang="scss" scoped>
@import "./date-clock.scss";
</style>
