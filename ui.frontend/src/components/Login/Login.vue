<template>
  <div id="login">
    <div class="loginContainer" v-on:keyup.enter="postAuth">
      <img class="logoTopLeft" :src="pageLogo"/>
      <div class="loginBox">
        <h1 class="title">{{title}}</h1>
        <p class="description">{{description}}</p>
        <p class="formLabel">{{formLabel}}</p>
        <input v-model="loginFormData.j_username"
          :placeholder="userPlaceholder"
          :class="{'loginFailed': this.authFailed}"/>
        <input v-model="loginFormData.j_password"
          :placeholder="passwordPlaceholder"
          :class="{'loginFailed': this.authFailed}"
          autocomplete="new-password"
          type="password"/>
        <div class="authFailed">
          <p v-if="this.authFailed">{{loginFailedText}}</p>
        </div>
        <button @click="postAuth">{{buttonText}}</button>
      </div>
    </div>
    <div class="loginBackground" :style="loginBackgroundCss">
      <img class="logoTopRight" :src="pageLogo"/>
    </div>
  </div>
</template>

<script>
import qs from 'qs'

export default {
  name: 'Login',
  props: {
    title: {
      type: String
    },
    description: {
      type: String
    },
    formLabel: {
      type: String
    },
    userPlaceholder: {
      type: String
    },
    passwordPlaceholder: {
      type: String
    },
    buttonText: {
      type: String
    },
    buttonLink: {
      type: String
    },
    loginFailedText: {
      type: String
    },
    pageLogo: {
      type: String
    },
    loginBackground: {
      type: String
    }
  },
  data () {
    /* eslint-disable @typescript-eslint/camelcase */
    return {
      loginFormData: {
        j_username: '',
        j_password: '',
        j_validate: true
      },
      authFailed: false
    }
  },
  methods: {
    postAuth () {
      this.$http.post('/libs/granite/core/content/login.html/j_security_check', qs.stringify(this.loginFormData), {
        headers: {
          'Content-type': 'application/x-www-form-urlencoded'
        }
      }).then(response => {
        if (response.status === 200) {
          localStorage.setItem('isLoggedIn', true)
          localStorage.setItem('user', this.loginFormData.j_username)
          this.$router.push({ path: this.getRedirectUtl() })
          this.$router.go()
        } else {
          this.authFailedAction()
          console.log(response)
        }
      }).catch(err => {
        this.authFailedAction()
        console.log(err)
      })
    },
    authFailedAction () {
      this.authFailed = true
    },
    getRedirectUtl () {
      return this.buttonLink.includes('.html') ? this.buttonLink : this.buttonLink + '.html'
    }
  },
  computed: {
    loginBackgroundCss () {
      return {
        background: 'url(' + this.loginBackground + ')'
      }
    }
  },
  mounted () {
    document.body.classList.add('login-body')
  }
}
</script>

<style lang="scss">
@import "./login.scss";
</style>
