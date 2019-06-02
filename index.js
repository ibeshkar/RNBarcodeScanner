import {NativeModules} from 'react-native';

const RNBarcodeScanner = NativeModules.RNBarcodeScanner;

const RNScanner = {};

RNScanner.scan = () => {
    return RNBarcodeScanner.scan()
};

export default RNScanner;
