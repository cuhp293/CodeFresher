import 'package:flutter/material.dart';
import '../models/flashcard.dart';
import '../services/flashcard_storage.dart';
import 'flashcard_screen.dart';
import 'add_flashcard_screen.dart';
import 'search_screen.dart';

class HomeScreen extends StatefulWidget {
  const HomeScreen({Key? key}) : super(key: key);

  @override
  _HomeScreenState createState() => _HomeScreenState();
}

class _HomeScreenState extends State<HomeScreen> {
  // Danh sách từ vựng mẫu
  // final List<Flashcard> _flashcards = [
  //   Flashcard(
  //     id: '1',
  //     word: 'Hello',
  //     meaning: 'Xin chào',
  //     example: 'Hello, how are you?',
  //   ),
  //   Flashcard(
  //     id: '2',
  //     word: 'Goodbye',
  //     meaning: 'Tạm biệt',
  //     example: 'Goodbye, see you tomorrow!',
  //   ),
  //   Flashcard(
  //     id: '3',
  //     word: 'Thank you',
  //     meaning: 'Cảm ơn',
  //     example: 'Thank you for your help.',
  //   ),
  // ];

  List<Flashcard> _flashcards = [];
  bool _isLoading = true;

  @override
  void initState() {
    super.initState();
    _loadFlashcards();
  }

  Future<void> _loadFlashcards() async {
    final cards = await FlashcardStorage.loadFlashcards();
    setState(() {
      _flashcards = cards;
      if (_flashcards.isEmpty) {
        // Thêm dữ liệu mẫu nếu không có dữ liệu nào
        _flashcards = [
          Flashcard(
            id: '1',
            word: 'Hello',
            meaning: 'Xin chào',
            example: 'Hello, how are you?',
          ),
          Flashcard(
            id: '2',
            word: 'Goodbye',
            meaning: 'Tạm biệt',
            example: 'Goodbye, see you tomorrow!',
          ),
          Flashcard(
            id: '3',
            word: 'Thank you',
            meaning: 'Cảm ơn',
            example: 'Thank you for your help.',
          ),
        ];
        // Lưu dữ liệu mẫu
        FlashcardStorage.saveFlashcards(_flashcards);
      }
      _isLoading = false;
    });
  }

  void _addFlashcard(Flashcard newCard) {
    setState(() {
      _flashcards.add(newCard);
      FlashcardStorage.saveFlashcards(_flashcards);
    });
  }

  void _deleteFlashcard(String id) {
    setState(() {
      _flashcards.removeWhere((card) => card.id == id);
      FlashcardStorage.saveFlashcards(_flashcards);
    });
  }

  void _toggleMemorized(String id) {
    setState(() {
      final index = _flashcards.indexWhere((card) => card.id == id);
      if (index != -1) {
        _flashcards[index] = _flashcards[index].copyWith(
          isMemorized: !_flashcards[index].isMemorized,
        );
        FlashcardStorage.saveFlashcards(_flashcards);
      }
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Ứng dụng học từ vựng'),
        actions: [
          IconButton(
            icon: const Icon(Icons.play_arrow),
            onPressed: _flashcards.isEmpty
                ? null
                : () {
              Navigator.push(
                context,
                MaterialPageRoute(
                  builder: (context) => FlashcardScreen(flashcards: _flashcards),
                ),
              );
            },
            tooltip: 'Bắt đầu học',
          ),
        ],
      ),
      body: _flashcards.isEmpty
          ? const Center(
        child: Text(
          'Chưa có từ vựng nào.\nHãy thêm từ vựng mới!',
          textAlign: TextAlign.center,
          style: TextStyle(fontSize: 18),
        ),
      )
          : ListView.builder(
        itemCount: _flashcards.length,
        itemBuilder: (context, index) {
          final card = _flashcards[index];
          return Dismissible(
            key: Key(card.id),
            background: Container(
              color: Colors.red,
              alignment: Alignment.centerRight,
              padding: const EdgeInsets.only(right: 20),
              child: const Icon(
                Icons.delete,
                color: Colors.white,
              ),
            ),
            direction: DismissDirection.endToStart,
            onDismissed: (_) => _deleteFlashcard(card.id),
            child: ListTile(
              title: Text(card.word),
              subtitle: Text(card.meaning),
              trailing: IconButton(
                icon: Icon(
                  card.isMemorized
                      ? Icons.check_circle
                      : Icons.check_circle_outline,
                  color: card.isMemorized ? Colors.green : Colors.grey,
                ),
                onPressed: () => _toggleMemorized(card.id),
              ),
            ),
          );
        },
      ),
      floatingActionButton: FloatingActionButton(
        child: const Icon(Icons.add),
        onPressed: () {
          Navigator.push(
            context,
            MaterialPageRoute(
              builder: (context) => AddFlashcardScreen(
                addFlashcard: _addFlashcard,
              ),
            ),
          );
        },
      ),
    );
  }
}