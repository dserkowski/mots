import React, { Component } from 'react';
import PropTypes from 'prop-types';

import AwesomeAlert from 'react-native-awesome-alerts';

// const drawerStyles = {
//   drawer: {
//     shadowColor: '#000',
//     shadowOpacity: 0.3,
//     shadowRadius: 1,
//   },
//   main: {
//     paddingLeft: 0,
//   },
// };

class Alert extends Component {
  constructor(props) {
    super(props);
    this.showAlert = this.showAlert.bind(this);
    this.hideAlert = this.hideAlert.bind(this);
    this.state = { isAlertShowed: true };
    this.forceUpdate();
  }
  showAlert = () => {
    this.setState({
      isAlertShowed: true,
    });
  };
  hideAlert = () => {
    this.setState({
      isAlertShowed: false,
    });
  };
  render() {
    const { isAlertShowed } = this.state;
    const { title, message } = this.props;

    return (
      <AwesomeAlert
        show={isAlertShowed}
        showProgress={false}
        title={title}
        message={message}
        closeOnTouchOutside
        closeOnHardwareBackPress={false}
        showCancelButton
        showConfirmButton
        cancelText="No, cancel"
        confirmText="Yes, delete it"
        confirmButtonColor="#DD6B55"
        onCancelPressed={() => {
              this.hideAlert();
            }}
        onConfirmPressed={() => {
              this.hideAlert();
            }}
      />
    );
  }
}

export default Alert;

Alert.propTypes = {
  title: PropTypes.string.isRequired,
  message: PropTypes.string.isRequired,
};
