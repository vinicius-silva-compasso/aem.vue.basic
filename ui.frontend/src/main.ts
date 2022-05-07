import './map-components'
import { AuthoringUtils, ModelManager } from '@adobe/aem-spa-page-model-manager'
import Vue from 'vue'
import App from './App'
import VueRouter from 'vue-router'
import { Constants } from '@mavice/aem-vue-editable-components'
import axios from 'axios'

Vue.use(VueRouter)
Vue.prototype.$http = axios

document.addEventListener('DOMContentLoaded', () => {
  ModelManager.initialize().then(pageModel => {
    new Vue({
      router: new VueRouter({
        mode: 'history',
        routes: []
      }),
      render (createElement: Function) {
        return createElement(App, {
          props: {
            cqChildren: pageModel[Constants.CHILDREN_PROP],
            cqItems: pageModel[Constants.ITEMS_PROP],
            cqItemsOrder: pageModel[Constants.ITEMS_ORDER_PROP],
            cqPath: pageModel[Constants.PATH_PROP],
            isInEditor: AuthoringUtils.isInEditor(),
            locationPathname: window.location.pathname,
            injectPropsOnInit: true
          }
        })
      },
      created () {
        // TODO - revisar se tem uma forma melhor de fazer isso ... se tem alguma maneira de pegar qual a página de login através de alguma config do AEM
        if (!AuthoringUtils.isInEditor() && !localStorage.getItem('isLoggedIn') && this.$route.path !== '/content/vue/vue/login.html') {
          this.$router.push({ path: '/content/vue/vue/login.html' })
          this.$router.go(0)
        }
      }
    }).$mount('#spa-root')
  })
})
