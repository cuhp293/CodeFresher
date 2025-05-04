import 'package:flutter/material.dart';
import '../models/flashcard.dart';
import 'package:uuid/uuid.dart';

class AddFlashcardScreen extends StatefulWidget {
  final Function(Flashcard) addFlashcard;

  const AddFlashcardScreen({
    Key? key,
    required this.addFlashcard,
  }) : super(key: key);

  @override
  _AddFlashcardScreenState createState() => _AddFlashcardScreenState();
}

class _AddFlashcardScreenState extends State<AddFlashcardScreen> {
  final _formKey = GlobalKey<FormState>();
  final _wordController = TextEditingController();
  final _meaningController = TextEditingController();
  final _exampleController = TextEditingController();

  @override
  void dispose() {
    _wordController.dispose();
    _meaningController.dispose();
    _exampleController.dispose();
    super.dispose();
  }

  void _saveFlashcard() {
    if (_formKey.currentState!.validate()) {
      // Sử dụng UUID để tạo ID duy nhất
      final uuid = Uuid();
      final id = uuid.v4(); // Tạo UUID phiên bản 4 (ngẫu nhiên)

      final newCard = Flashcard(
        id: id,
        word: _wordController.text.trim(),
        meaning: _meaningController.text.trim(),
        example: _exampleController.text.trim(),
      );

      widget.addFlashcard(newCard);
      Navigator.pop(context);
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Thêm từ vựng mới'),
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Form(
          key: _formKey,
          child: SingleChildScrollView(
            child: Column(
              children: [
                TextFormField(
                  controller: _wordController,
                  decoration: const InputDecoration(
                    labelText: 'Từ mới',
                    border: OutlineInputBorder(),
                  ),
                  validator: (value) {
                    if (value == null || value.isEmpty) {
                      return 'Vui lòng nhập từ vựng';
                    }
                    return null;
                  },
                ),
                const SizedBox(height: 16),
                TextFormField(
                  controller: _meaningController,
                  decoration: const InputDecoration(
                    labelText: 'Nghĩa',
                    border: OutlineInputBorder(),
                  ),
                  validator: (value) {
                    if (value == null || value.isEmpty) {
                      return 'Vui lòng nhập nghĩa của từ';
                    }
                    return null;
                  },
                ),
                const SizedBox(height: 16),
                TextFormField(
                  controller: _exampleController,
                  decoration: const InputDecoration(
                    labelText: 'Ví dụ (không bắt buộc)',
                    border: OutlineInputBorder(),
                  ),
                  maxLines: 3,
                ),
                const SizedBox(height: 24),
                ElevatedButton(
                  onPressed: _saveFlashcard,
                  child: const Text('Lưu từ vựng'),
                  style: ElevatedButton.styleFrom(
                    minimumSize: const Size(double.infinity, 50),
                  ),
                ),
              ],
            ),
          ),
        ),
      ),
    );
  }
}