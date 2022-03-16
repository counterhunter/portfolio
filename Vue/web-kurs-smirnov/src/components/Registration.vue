<template>
  <div id="main">
    <h2>Регистрация</h2>
    <div>
      <p>Почта</p>
      <input type="text" placeholder="example@mail.ru">
    </div>
    <div>
      <p>Логин</p>
      <input type="text">
    </div>
    <div>
      <p>Пароль</p>
      <input type="password">
    </div>
    <div>
      <p>Повторите пароль</p>
      <input type="password">
    </div>
    
    <router-link to=""><input type="submit" value="Зарегистрироваться" class="reg-button"/></router-link>
  </div>
</template>

<script>

  export default {
    name: 'Registration',
     
  }
</script>

<style scoped>
  #main {
    background-color: #FFFFFF;
    outline: 10px solid black;
    padding: 20px;
    margin: 20px 25vw 10px 25vw;
    font-family: Ubuntu;
    font-size: 25px;
  }
  h2{
    text-align: center;
  }
  p{
    margin: 0px
  }
  input{
    font-size: 25px;
    margin: 4px 0px 16px 0px;
  }
  .reg-button{
    color: white;
    width: 290px;
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
    font-size: 20px;
  }
</style>