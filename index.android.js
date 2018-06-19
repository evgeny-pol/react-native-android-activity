/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 */

import React, { Component } from 'react';

import {
  AppRegistry,
  Button,
  NativeEventEmitter,
  NativeModules,
  StyleSheet,
  Text,
  View
} from 'react-native';

import BatchedBridge from "react-native/Libraries/BatchedBridge/BatchedBridge";

import codePush from "react-native-code-push";

export class ExposedToJava {
  alert(message) {
      alert(message);
  }
}

const exposedToJava = new ExposedToJava();
BatchedBridge.registerCallableModule("JavaScriptVisibleToJava", exposedToJava);

const activityStarter = NativeModules.ActivityStarter;

export default class ActivityDemoComponent extends Component {
  render() {
    return (
      <View style={styles.container}>
        <Text style={styles.welcome}>
          Welcome to face recognizer! 4
        </Text>       
        <View style={styles.buttonContainer}>
          <Button
            onPress={() => activityStarter.navigateToImageClassifier()}
            title='Open camera'
          />          
        </View>
      </View>
    );
  }
}

const styles = StyleSheet.create({
  buttonContainer: {
    height: 300,
    width: 220,
    justifyContent: 'space-between',
    marginTop: 50,
  },
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF',
  },
  welcome: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10,
  },
  instructions: {
    textAlign: 'center',
    color: '#333333',
    marginBottom: 5,
  },
});

let codePushOptions = { checkFrequency: codePush.CheckFrequency.MANUAL, installMode: codePush.InstallMode.IMMEDIATE };

ActivityDemoComponent = codePush(codePushOptions)(ActivityDemoComponent);
AppRegistry.registerComponent('ActivityDemoComponent', () => ActivityDemoComponent);

const eventEmitter = new NativeEventEmitter(activityStarter);
eventEmitter.addListener(activityStarter.MyEventName, (params) => alert(params));

