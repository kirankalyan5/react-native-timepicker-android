import React, { Component, PropTypes } from 'react'
import {
    requireNativeComponent,
    ViewPropTypes
} from 'react-native'


class TimePicker extends Component {

    constructor(props){
        super(props)
        this.handleChange = this.handleChange.bind(this)
    }

    handleChange(event){
        this.props.onTimeSelected(event.nativeEvent.hour, event.nativeEvent.minute)
    }

    render() {
        return (
            <RNTimePicker {...this.props} 
                onChange={this.handleChange}
               />
        )
    }
}


TimePicker.propTypes = Object.assign({}, ViewPropTypes, {
    hour: PropTypes.number.isRequired,
    minute: PropTypes.number.isRequired,
    is24Hour: PropTypes.bool.isRequired,
    onTimeSelected: PropTypes.func
})

TimePicker.defaultProps = {
    is24Hour: true
}

let RNTimePicker = requireNativeComponent('RNTimePicker', TimePicker, {
  nativeOnly: {timeChanged: true}
})

export default TimePicker