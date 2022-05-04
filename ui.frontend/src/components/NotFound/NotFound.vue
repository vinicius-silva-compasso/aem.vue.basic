<template>
    <div id="notfound" class="flex-direction">
        <div id="container-leftside">
            <img v-if="image" :src="image.src"/>
        </div>
        <div id="container-rightside">
            <p class="notfound-upper-text">{{upperText}}</p>
            <p class="notfound-middle-text">{{middleText}}</p>
            <button @click="handleButtonClick" class="notfound-button">{{buttonText}}</button>
        </div>
    </div>
</template>

<script>
export default {
  name: 'NotFound',
  props: {
    image: {
      type: Object
    },
    upperText: {
      type: String
    },
    middleText: {
      type: String
    },
    buttonText: {
      type: String
    },
    buttonLink: {
      type: String
    }
  },
  methods: {
    handleButtonClick () {
      this.$router.push({ path: this.buttonLink.includes('.html') ? this.buttonLink : this.buttonLink + '.html' })
      this.$router.go()
    }
  }
}
</script>

<style lang="scss">
body {
    overflow: hidden;
}
#notfound {
    height: 80vh;
    max-height: 750px;
    display: inline-flex;
    flex-wrap: wrap;
    flex-direction: row;
    #container-leftside {
        width: 50%;
        height: 100%;
        display: flex;
        justify-content: center;
        align-items: center;
        img {
            min-width: 286.83px;
            max-width: 35vw;
        }
    }
    #container-rightside {
        width: 50%;
        height: 100%;
        display: flex;
        flex-direction: column;
        align-content: center;
        font-family: 'Space Mono';
        font-style: normal;
        .notfound-upper-text {
            width: 586px;
            height: 190px;

            font-weight: 700;
            font-size: 64px;
            line-height: 95px;
            letter-spacing: -0.035em;

            color: #333333;
        }

        .notfound-middle-text {
            width: 381px;
            height: 108px;

            font-weight: 400;
            font-size: 24px;
            line-height: 36px;
            letter-spacing: -0.035em;

            color: #4F4F4F;
        }

        .notfound-button {
            margin-top: 10vh;
            width: 216px;
            height: 68px;

            background: #333333;

            font-weight: 700;
            font-size: 14px;
            line-height: 21px;

            letter-spacing: -0.035em;
            text-transform: uppercase;

            color: #FFFFFF;

        }
    }
}

@media screen and (max-width: 768px) {
    #notfound {
        margin: 2vw 0 0 2vw;
        flex-direction: column;
        #container-leftside {
            width: 100%;
            height: 30vh;
            display: flex;
            justify-content: center;
            align-items: center;
            img {
                max-width: 35vw;
            }
        }
        #container-rightside {
            width: 100%;
            height: 50vh;
            .notfound-upper-text {
                width: 350px;
                height: 142px;
                font-size: 48px;
                line-height: 71px;
                margin-top: 2vh;
                margin-bottom: 2vh;
            }
            .notfound-middle-text {
                width: 328px;
                height: 81px;
                font-size: 18px;
                line-height: 27px;
            }
            .notfound-button {
                margin-top: 4vh;
            }
        }
    }
}
</style>
