import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

const methodChannel = MethodChannel("method_channel");

class HomeScreen extends StatelessWidget {
  const HomeScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("Vibrate me"),
        centerTitle: true,
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            ElevatedButton(
              child: const Text("Simple vibrate"),
              onPressed: () {
                methodChannel.invokeMethod("simple_vibrate");
              },
            ),
            ElevatedButton(
              child: const Text("Waveform"),
              onPressed: () {
                methodChannel.invokeMethod("wave_form");
              },
            ),
          ],
        ),
      ),
    );
  }
}
