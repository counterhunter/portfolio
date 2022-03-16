<template>
    <div id="app">
        <sidebar-menu 
        :menu="menu"
        :width="width"
        :theme="theme"
        :hideToggle="hideToggle"
        />
      
      <div class="admin">
        ADMIN PANEL
        <!-- <router-link to="/">Home</router-link> |
        <router-link to="/about">About</router-link> -->
      </div>
      <router-view/>
    </div>
</template>







<script>
  export default {
    name: 'Lessons',
      data() {
      return {
        menu: [
          {
            header: true,
            title: 'Уроки',
            hiddenOnCollapse: true
          },
          {
            href: '/overview',
            title: 'Введение',
          },
          {
            href: '/lesson/1',
            title: 'Урок 1',
          },
          {
            href: '/lesson/2',
            title: 'Урок 2',
          },
          {
            href: '/lesson/3',
            title: 'Урок 3',
          },
          {
            href: '/lesson/4',
            title: 'Урок 4',
          },
        ],
        width: '350px',
        theme: 'white-theme',
        hideToggle: true,
      }
    },
    methods: {
    }
  }
</script>






<style scoped>
  /* #sidebar{
    
  } */
  input,button{
    margin: 3px;
    background-color: rgb(88, 153, 207); 
    border: none;
    color: white;
    padding: 8px 16px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 14px;
  }
  
  .admin {
    background-color: red;
    border: 1px solid #CCCCCC;
    padding: 20px;
    margin: 10px 10px 10px 375px;
    font-family: Ubuntu;
  }
  .v-sidebar-menu.vsm_expanded {
    border: 1px solid #CCCCCC;
    background-color: #FFFFFF;
    padding: 20px;
    font-family: Ubuntu;
  }
</style>