<template>
  <div id="login">
    <h1>Вход</h1>
    <input type="text" name="username" v-model="input.username" placeholder="Логин" />
    <input type="password" name="password" v-model="input.password" placeholder="Пароль" />
    <button type="button" v-on:click="login()">Войти</button>
  </div>
</template>

<script>
    export default {
        name: 'Login',
        data() {
            return {
                input: {
                    username: "admin",
                    password: "12345678"
                }
            }
        },
        methods: {
            login() {
                if(this.input.username != "" && this.input.password != "") {
                    if(this.input.username == this.$parent.mockAccount.username &&
                    this.input.password == this.$parent.mockAccount.password) {
                        this.$emit("authenticated", true);
                        this.$router.replace({ name: "main" });
                    } else {
                        alert("Имя пользователя или пароль неверны");
                    }
                } else {
                    alert("Введите имя пользователя и пароль");
                }
            }
        }
    }
</script>

<style scoped>
    #login {
        width: 500px;
        border: 1px solid #CCCCCC;
        /* background-color: #FFFFFF; */
        margin: auto;
        margin-top: 200px;
        padding: 20px;
    }
    input,button{
        margin: 3px;
    }
</style>