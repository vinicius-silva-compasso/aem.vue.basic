<template>
  <footer>
    <p v-html="text"></p>
  </footer>
</template>

<script>
export default {
  name: 'Footer',
  props: {
    text: {
      type: String
    }
  }
}
</script>

<style lang="scss" scoped>
footer {
  height: 45px;
  p {
    font-family: 'Montserrat';
    font-style: normal;
    font-weight: 500;
    font-size: 14px;
    line-height: 17px;

    text-align: center;

    color: #BDBDBD;
  }
}
</style>
