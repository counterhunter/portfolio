<template>
  <div id="demo" :class="[{'collapsed' : collapsed}]">
    <div class="demo">
      <div class="container">
        <h1>
          vue-sidebar-menu
        </h1>
        <hr style="margin: 50px 0px;border: 1px solid #e3e3e3;">
        <router-view />
      </div>
      <sidebar-menu
        :menu="menu"
        :collapsed="collapsed"
        @toggle-collapse="onToggleCollapse"
        @item-click="onItemClick"
      />
    </div>
  </div>
</template>

<script>
const separator = {
  template: `<hr style="border-color: rgba(0, 0, 0, 0.1); margin: 20px;">`
}
import {SidebarMenu} from 'vue-sidebar-menu'
export default {
  name: 'Main',
  components:{SidebarMenu},
  data () {
    return {
     menu: [
        {
          header: true,
          title: 'Навигация',
          hiddenOnCollapse: true
        },
        {
          href: '/employees',
          //href: { path: '/employees' },
          title: 'Сотрудники',
          icon: 'fa fa-chart-area',
        },
        {
          href: { path: '/books' },
          title: 'Трудовые книжки',
          icon: 'fa fa-chart-area',
        },
        {
          href: { path: '/goods' },
          title: 'Товары',
          icon: 'fa fa-user',
        },
        {
          href: { path: '/sales' },
          title: 'Продажи',
          icon: 'fa fa-chart-area',
        },
        {
          href: { path: '/expired' },
          title: 'Истек срок годности',
          icon: 'fa fa-chart-area',
        },
      ],
      width: '250px',
      collapsed: true,
    }
  },
  methods: {
    onToggleCollapse (collapsed) {
      console.log(collapsed)
      this.collapsed = collapsed
    },
    onItemClick (event, item) {
      console.log('onItemClick')
      // console.log(event)
      // console.log(item)
    }
  }
}
</script>


<style >

body,
html {
  margin: 0;
  padding: 0;
}

body {
  font-family: 'Source Sans Pro', sans-serif;
  font-size: 18px;
  background-color: #f2f4f7;
  color: #262626;
}

#demo {
  padding-left: 250px;
}
#demo.collapsed {
  padding-left: 50px;
}

.demo {
  padding: 50px;
}

.container {
  max-width: 900px;
}

pre {
  font-family: Consolas, monospace;
  color: #000;
  background: #fff;
  border-radius: 2px;
  padding: 15px;
  line-height: 1.5;
  overflow: auto;
}
</style>
