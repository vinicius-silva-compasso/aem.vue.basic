<template>
  <div id="weather">
    <p class="city-name">{{cityName}}</p>
    <div class="sub-weather">
      <img :src="image"/>
      <p class="temperature">{{temperature}}</p>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Weather',
  data () {
    return {
      cityName: '',
      temperature: '',
      image: ''
    }
  },
  methods: {
    updateWeatherInfo () {
      // do we support geolocation
      if (!('geolocation' in navigator)) {
        console.log('Geolocation is not available.')
        return
      }

      console.log('Getting location...')
      console.log(navigator.geolocation)
      navigator.geolocation.getCurrentPosition(pos => {
        const location = pos
        this.callWeatherApi(location.coords.latitude + ',' + location.coords.longitude)
      }, err => {
        console.log(err.message)
      })
    },
    callWeatherApi (q) {
      this.$http.get('https://api.weatherapi.com/v1/current.json', {
        params: {
          q: q,
          key: '2d234bc0de8f4fbcb9c171627220605' // TODO - verificar onde é melhor armazenar chaves com o vue no AEM... alguma config do AEM? properties? env?
        }
      }, {
        headers: {
          'Content-type': 'application/x-www-form-urlencoded'
        }
      }).then(response => {
        console.log(response.data)
        this.cityName = response.data.location.name + ' - ' + response.data.location.region
        this.temperature = response.data.current.temp_c + '°'
        this.image = response.data.current.condition.icon
      }).catch(err => {
        console.log(err)
      })
    }
  },
  created () {
    this.updateWeatherInfo()
    setInterval(this.updateWeatherInfo, 60000)
  }
}
</script>

<style lang="scss" scoped>
@import "./weather.scss";
</style>
