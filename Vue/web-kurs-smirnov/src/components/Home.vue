<template>
  <div class="home">
    
    <fixed-header>
      <div class="navbar">
        <div> 
          <img src="../assets/logo.png"/>
          <span class="title">WABI-SABI</span>
        </div>
        <div class="spacer"></div>
        <router-link to="reg"><input type="submit" value="Регистрация" class="button"/></router-link>
        <input type="submit" value="Войти" class="button" @click="showLogin = true"/>
        
      </div>
    </fixed-header>

    <div class="parent" v-if="showLogin">
      <a class="close" @click="showLogin = false"></a>
      <div class="login">
        <login-form :data="loginFormData" @sign-in="signIn"/>
      </div>
    </div>
    
    <router-link to="workspace"><h1>Начнём?</h1></router-link>
    <div class="text">
      <h3 align="justify">
        WABI-SABI -- это онлайн учебник нового поколения. 
        Здесь вы получите доступ к десяткам бесплатных материалов
        от ведущих IT-специалистов.
      </h3>
    </div>
    <div class="footer">
      Copyright © Alexey Smirnov, 2020
    </div>
  </div>
</template>







<script>
import LoginForm from 'vue-login-form';
import FixedHeader from 'vue-fixed-header'
export default {
  name: 'Home',
  components: {
    FixedHeader,
    LoginForm
  },
  data() {
    return {
      showLogin: false,
      loginFormData: {

      title: 'Вход',
      form: false,
      // action: 'http://127.0.0.1:5000/about',
      buttonText: 'Войти',
      inputList: [
        {
          id: 'account',
          label: 'Логин',
          type: 'text',
          placehold: 'Account',
          auto: 'login',
          value: 'admin'
        },
        {
          id: 'password',
          label: 'Пароль',
          type: 'password',
          placehold: 'Password',
          auto: 'current-password',
          value: '123'
        },
        ],
        
      },
    }
  },
}
</script>







<style>
.home {
  font-family: Ubuntu;
  background-image: url("../assets/home.png");
  background-repeat: no-repeat;
  background-size: 50%;
  background-position: left bottom;
  height: 100vh;
}
body{
  margin: 0;
  padding: 0;
  animation: fadein 2s;
  background-image: url("../assets/body.png");
}
.vue-fixed-header {
  background-color: white;
  outline: 10px solid black;
  margin: 0% 1% 0% 1%;
  box-shadow: 0 19px 38px rgba(0,0,0,0.19), 0 30px 30px rgba(0,0,0,0.23);
  height: 70px;
  padding: 3px;
}
h1{
  text-align: center;
  font-size: 70px;
}
.text{
  max-width: 470px;
  /* margin: 1% 10% 3% 10%; */
  width: 50%; margin: 0 auto; text-align: center;
}
img{
  width: 70px;
}
a{
  color:black;
}
a:visited{
  color:black;
}
.navbar{
  padding: 10px;
  display: flex;
  flex-direction: row;
  justify-content: flex-start;
}
.spacer{
  flex-grow: 2;
}
.button{
  color: white;
  width: 270px;
  height: 70px;
  font-size: 24px;
  font-family: Ubuntu;
  cursor: pointer;
  background-color: Transparent;
  border: none;
  overflow: hidden;
  background: url(../assets/stroke.png) no-repeat scroll 0 0 transparent;
  background-size: cover;
  outline:none;
}

.title{
  font-family: Shanghai;
  font-size: 30px;
}
.footer{
  position: fixed; /* Фиксированное положение */
  bottom: 0; /* Левый нижний угол */
  right: 0;
  color:#AAAAAA;
  margin: 10px;
}
.parent {
  width: 100%;
  height: 100%;
  position: absolute;
  top: 0;
  left: 0;
  overflow: auto;
  background-color: rgba(0, 0, 0, 0.5);
  animation: fadein 0.3s;
}
.login{
  position: fixed;
  z-index: 9998;
  top: 30%;
  left: 40%;
}

.close {
  position: absolute;
  right: 38%;
  z-index: 9999;
  top: 30%;
  width: 32px;
  height: 32px;
  opacity: 0.3;
}
.close:hover {
  opacity: 1;
}
.close:before, .close:after {
  position: absolute;
  left: 15px;
  content: ' ';
  height: 33px;
  width: 2px;
  background-color: black;
}
.close:before {
  transform: rotate(45deg);
}
.close:after {
  transform: rotate(-45deg);
}
@font-face {
  font-family: Shanghai; /* Гарнитура шрифта */
  src: url(../fonts/shanghai.ttf); /* Путь к файлу со шрифтом */
}
@font-face {
  font-family: Ubuntu; /* Гарнитура шрифта */
  src: url(../fonts/ubuntu.ttf); /* Путь к файлу со шрифтом */
}
.fadeIn{
  animation: fadeIn 0.5s ease-in;
  }
@keyframes fadein {
  from { opacity: 0; }
  to   { opacity: 1; }
}
</style> 
