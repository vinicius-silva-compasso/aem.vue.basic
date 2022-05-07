import CustomClasses from './components/CustomClasses/CustomClasses'
import Text from './components/Text/Text'
import AppPage from './components/Page/AppPage'
import CheckBox from './components/Checkbox/Checkbox'
import Header from './components/Header/Header'
import Footer from './components/Footer/Footer'
import LoggedHeader from './components/LoggedHeader/LoggedHeader'
import LoggedFooter from './components/LoggedFooter/LoggedFooter'
import Image from './components/Image/Image'
import {
  withComponentMappingContext,
  AllowedComponentsContainer,
  MapTo
} from '@mavice/aem-vue-editable-components'
import CustomHeader from './components/CustomHeader/CustomHeader'
import NotFound from './components/NotFound/NotFound'
import Login from './components/Login/Login'
import Home from './components/Home/Home'

MapTo('vue/components/page')(withComponentMappingContext(AppPage))

// Custom EditConfig for General New Vue Components
const EditConfig = {
  emptyLabel: 'Empty',

  isEmpty: function (props) {
    return !props
  }
}
/** *******************************************************************
              ↓  NEW COMPONENTS MAPPING COME HERE  ↓
**********************************************************************/

MapTo('vue/components/customclasses')(CustomClasses, EditConfig)

// Checkbox Component Mapping
MapTo('vue/components/checkbox')(CheckBox, EditConfig)

// Header Component Mapping
MapTo('vue/components/header')(Header, EditConfig)

// Footer Component Mapping
MapTo('vue/components/footer')(Footer, EditConfig)

// Logged Header Component Mapping
MapTo('vue/components/logged-header')(LoggedHeader)

// Logged Footer Component Mapping
MapTo('vue/components/logged-footer')(LoggedFooter)

// Image Component Mapping
MapTo('vue/components/image')(Image, {
  emptyLabel: 'Image',
  isEmpty: function (props) {
    return !props || !props.src || props.src.trim().length < 1
  },
  resourceType: 'vue/components/image'
})

// Text Component Mapping
MapTo('vue/components/text')(Text, {
  emptyLabel: 'Text',

  isEmpty: function (props) {
    return !props || !props.text || props.text.trim().length < 1
  }
})

// Container Component Mapping
MapTo('vue/components/container')(
  withComponentMappingContext(AllowedComponentsContainer),
  {
    emptyLabel: 'Container',

    isEmpty: function (props) {
      return !props || !props.cqItemsOrder || props.cqItemsOrder.length === 0
    }
  }
)

// Custom Header Component Mapping
MapTo('vue/components/custom-header')(CustomHeader)

// Not Found Component Mapping
MapTo('vue/components/not-found')(NotFound)

// Login Component Mapping
MapTo('vue/components/login')(Login)

// Home Component Mapping
MapTo('vue/components/home')(Home)
