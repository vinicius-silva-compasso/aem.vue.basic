<template>
  <footer>
    <p class="description">{{description}}</p>
    <div class="pipe"></div>
    <div class="text-region"/>
    <div class="text-region refresh">{{applicationLabel}}<br>{{refreshLabel}}</div>
    <div class="text-region"><div class="seconds-number">{{timerCount}}</div><div>{{secondsLabel}}</div></div>
    <div class="text-region"/>
    <div class="continue-button" @click="continueNavigation">{{continueNavigationLabel}}</div>
    <div class="logout-button" @click="logout">{{logoutLabel}}</div>
  </footer>
</template>

<script>
const TOTAL_TIMER = 600 // TODO - parametrizar o valor do timer
export default {
  name: 'LoggedFooter',
  props: {
    description: {
      type: String
    },
    applicationLabel: {
      type: String
    },
    refreshLabel: {
      type: String
    },
    secondsLabel: {
      type: String
    },
    continueNavigationLabel: {
      type: String
    },
    logoutLabel: {
      type: String
    }
  },
  data () {
    return {
      timerCount: TOTAL_TIMER
    }
  },
  methods: {
    continueNavigation () {
      this.timerCount = TOTAL_TIMER
    },
    logout () {
      localStorage.removeItem('isLoggedIn')
      localStorage.removeItem('user')
      this.$router.push({ path: '/content/vue/vue/login.html' }) // TODO - verificar onde seria o melhor lugar para armazenar alguns valores fixos. env? banco? config do aem?
      this.$router.go()
    }
  },
  watch: {
    timerCount: {
      handler (value) {
        if (value > 0) {
          setTimeout(() => {
            this.timerCount--
            if (this.timerCount === 0) {
              this.logout()
            }
          }, 1000)
        }
      },
      immediate: true
    }
  }
}
</script>

<style lang="scss" scoped>
@import "./logged-footer.scss";
</style>
