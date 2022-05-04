<template>
    <customheader class="custom-header">
        <h1>Este é o Header</h1>
        <p>Treinando com componte Vue no AEM</p>
        <p>{{ text }}</p>
        <p>{{ checkbox ? 'isChecked' : 'isNotChecked' }}</p>
    </customheader>
</template>

<script>
export default {
  name: 'CustomHeader',
  props: {
    text: {
      type: String,
      default: 'Texto padrão'
    },
    checkbox: {
      type: Boolean,
      default: false
    }
  }
}
</script>

<style lang="scss">
customheader {
    background-color: #ddd;
    padding: 20px;

    h1 {
        color: red;
    }
}
</style>
