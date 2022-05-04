<template>
  <header>
    <p>{{title}}</p>
  </header>
</template>

<script>
export default {
  name: 'Header',
  props: {
    title: {
      type: String
    }
  }
}
</script>

<style lang="scss" scoped>
@import url('https://fonts.googleapis.com/css2?family=Inconsolata:wght@700&family=Montserrat:wght@500;600;700&family=Space+Mono:wght@400;700&display=swap');

header {
  margin: 2vw 0 0 2vw;
  p {
    font-family: 'Inconsolata';
    font-style: normal;
    font-weight: 700;
    font-size: 24px;
    line-height: 25px;
    letter-spacing: -0.08em;
    text-transform: uppercase;

    color: #333333;
  }
}
</style>
