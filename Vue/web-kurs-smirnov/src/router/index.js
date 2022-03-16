import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

  const routes = [
  {
    path: '/',
    name: 'Home',
    component: () => import('../components/Home.vue')
  },
  {
    path:'/login',
    name: 'Login',
    component: () => import('../components/Login.vue')
  },
  {
    path:'/reg',
    name: 'Registration',
    component: () => import('../components/Registration.vue')
  },
  {
    path:'/workspace',
    name: 'Workspace',
    component: () => import('../components/Workspace.vue')
  },
  {
    path:'/overview',
    name: 'Overview',
    component: () => import('../components/Overview.vue')
  },
  {
    path:'/lesson/1',
    name: 'Lesson 1',
    component: () => import('../components/Lesson1.vue')
  }
]

const router = new VueRouter({
  routes
})

export default router
