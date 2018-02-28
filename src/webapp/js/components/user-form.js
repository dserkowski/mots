import _ from 'lodash';
import React, { Component } from 'react';
import { formValueSelector, reduxForm } from 'redux-form';
import PropTypes from 'prop-types';
import { connect } from 'react-redux';

import FormField from './form-field';
import { fetchRoles } from '../actions/index';

export const USER_FORM_NAME = 'UserForm';

const FIELDS = {
  username: {
    label: 'Username',
    required: true,
  },
  email: {
    label: 'Email',
    required: true,
  },
  name: {
    label: 'Name',
  },
  roleId: {
    label: 'Role',
    required: true,
    type: 'select',
    getSelectOptions: ({ roles }) => ({
      values: roles,
      displayNameKey: 'name',
      valueKey: 'id',
    }),
  },
  password: {
    label: 'Password',
    required: true,
    getAttributes: input => ({
      ...input,
      type: 'password',
      className: 'form-control',
    }),
  },
  passwordConfirm: {
    label: 'Confirm Password',
    required: true,
    getAttributes: input => ({
      ...input,
      type: 'password',
      className: 'form-control',
    }),
    getDynamicAttributes: ({ password }) => ({
      hidden: !password,
    }),
  },
};

class UserForm extends Component {
  constructor(props) {
    super(props);

    this.renderField = this.renderField.bind(this);
  }

  componentWillMount() {
    this.props.fetchRoles();
  }

  renderField(fieldConfig, fieldName) {
    return (
      <FormField
        key={fieldName}
        fieldName={fieldName}
        fieldConfig={fieldConfig}
        roles={this.props.roles}
        password={this.props.password}
      />
    );
  }

  render() {
    const { handleSubmit } = this.props;

    return (
      <form className="form-horizontal" onSubmit={handleSubmit(this.props.onSubmit)}>
        { _.map(FIELDS, this.renderField) }
        <div className="col-md-2" />
        <button type="submit" className="btn btn-primary margin-bottom-md">Submit</button>
        <button className="btn btn-danger margin-left-sm margin-bottom-md" onClick={this.props.onSubmitCancel}>Cancel</button>
      </form>
    );
  }
}

function validate(values) {
  const errors = {};

  _.each(FIELDS, (fieldConfig, fieldName) => {
    if (fieldConfig.required && !values[fieldName]) {
      errors[fieldName] = 'This field is required';
    }
  });
  if (values.password && (!values.passwordConfirm || values.passwordConfirm !== values.password)) {
    errors.passwordConfirm = 'Wrong value';
  }

  return errors;
}

const selector = formValueSelector(USER_FORM_NAME);


function mapStateToProps(state) {
  return {
    roles: state.tablesReducer.roles,
    password: selector(state, 'password'),
  };
}

export default reduxForm({
  validate,
  form: USER_FORM_NAME,
})(connect(mapStateToProps, { fetchRoles })(UserForm));

UserForm.propTypes = {
  handleSubmit: PropTypes.func.isRequired,
  onSubmitCancel: PropTypes.func.isRequired,
  onSubmit: PropTypes.func.isRequired,
  fetchRoles: PropTypes.func.isRequired,
  roles: PropTypes.arrayOf(PropTypes.shape({})),
  password: PropTypes.string,
};

UserForm.defaultProps = {
  roles: [],
  password: null,
};