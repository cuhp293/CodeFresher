import 'package:flutter/material.dart';
import '../models/flashcard.dart';
import '../services/flashcard_storage.dart';

class StudyModeScreen extends StatefulWidget {
  final List<Flashcard> flashcards;

  const StudyModeScreen({
    Key? key,
    required this.flashcards,
  }) : super(key: key);

  @override
  _StudyModeScreenState createState() => _StudyModeScreenState();
}

class _StudyModeScreenState extends State<StudyModeScreen> {
  int _currentIndex = 0;
  bool _showAnswer = false;
  List<Flashcard> _studyFlashcards = [];

  @override
  void initState() {
    super.initState();
    // Lọc danh sách từ vựng chưa thuộc
    _studyFlashcards = widget.flashcards
        .where((card) => !card.isMemorized)
        .toList();

    if (_studyFlashcards.isEmpty) {
      // Nếu đã thuộc hết, lấy toàn bộ danh sách để ôn tập
      _studyFlashcards = List.from(widget.flashcards);
    }

    // Xáo trộn danh sách để học hiệu quả hơn
    _studyFlashcards.shuffle();
  }

  void _markAsKnown() async {
    if (_currentIndex < _studyFlashcards.length) {
      final cardId = _studyFlashcards[_currentIndex].id;

      // Cập nhật trạng thái trong danh sách gốc
      final index = widget.flashcards.indexWhere((card) => card.id == cardId);
      if (index != -1) {
        setState(() {
          widget.flashcards[index] = widget.flashcards[index].copyWith(isMemorized: true);
        });

        // Lưu thay đổi vào bộ nhớ
        await FlashcardStorage.saveFlashcards(widget.flashcards);
      }

      _nextCard();
    }
  }

  void _markAsNotKnown() {
    _nextCard();
  }

  void _nextCard() {
    setState(() {
      if (_currentIndex < _studyFlashcards.length - 1) {
        _currentIndex++;
        _showAnswer = false;
      } else {
        // Hiển thị thông báo hoàn thành
        _showCompletionDialog();
      }
    });
  }

  void _showAnswer() {
    setState(() {
      _showAnswer = true;
    });
  }

  void _showCompletionDialog() {
    showDialog(
      context: context,
      barrierDismissible: false,
      builder: (context) => AlertDialog(
        title: const Text('Hoàn thành!'),
        content: Text(
          'Bạn đã học xong ${_studyFlashcards.length} từ vựng.\n'
              '${widget.flashcards.where((card) => card.isMemorized).length}/${widget.flashcards.length} từ đã thuộc.',
        ),
        actions: [
          TextButton(
            child: const Text('Học lại'),
            onPressed: () {
              Navigator.of(context).pop();
              setState(() {
                _studyFlashcards.shuffle();
                _currentIndex = 0;
                _showAnswer = false;
              });
            },
          ),
          TextButton(
            child: const Text('Quay lại'),
            onPressed: () {
              Navigator.of(context).pop();
              Navigator.of(context).pop();
            },
          ),
        ],
      ),
    );
  }

  @override
  Widget build(BuildContext context) {
    if (_studyFlashcards.isEmpty) {
      return Scaffold(
        appBar: AppBar(
          title: const Text('Học từ vựng'),
        ),
        body: const Center(
          child: Text(
            'Không có từ vựng nào để học.\nHãy thêm từ vựng mới!',
            textAlign: TextAlign.center,
            style: TextStyle(fontSize: 18),
          ),
        ),
      );
    }

    final currentCard = _studyFlashcards[_currentIndex];

    return Scaffold(
      appBar: AppBar(
        title: const Text('Học từ vựng'),
        actions: [
          Center(
            child: Padding(
              padding: const EdgeInsets.only(right: 16.0),
              child: Text(
                '${_currentIndex + 1}/${_studyFlashcards.length}',
                style: const TextStyle(fontSize: 16),
              ),
            ),
          ),
        ],
      ),
      body: Column(
        children: [
          Expanded(
            child: Padding(
              padding: const EdgeInsets.all(16.0),
              child: Card(
                elevation: 8,
                shape: RoundedRectangleBorder(
                  borderRadius: BorderRadius.circular(16.0),
                ),
                child: Container(
                  width: double.infinity,
                  decoration: BoxDecoration(
                    gradient: LinearGradient(
                      begin: Alignment.topLeft,
                      end: Alignment.bottomRight,
                      colors: [
                        Colors.blue.shade100,
                        Colors.blue.shade200,
                      ],
                    ),
                    borderRadius: BorderRadius.circular(16.0),
                  ),
                  child: Padding(
                    padding: const EdgeInsets.all(20.0),
                    child: Column(
                      mainAxisAlignment: MainAxisAlignment.center,
                      children: [
                        Text(
                          currentCard.word,
                          style: const TextStyle(
                            fontSize: 28,
                            fontWeight: FontWeight.bold,
                          ),
                          textAlign: TextAlign.center,
                        ),
                        if (_showAnswer) ...[
                          const SizedBox(height: 30),
                          const Divider(thickness: 1),
                          const SizedBox(height: 20),
                          Text(
                            currentCard.meaning,
                            style: const TextStyle(
                              fontSize: 24,
                              color: Colors.black87,
                            ),
                            textAlign: TextAlign.center,
                          ),
                          if (currentCard.example.isNotEmpty) ...[
                            const SizedBox(height: 20),
                            const Text(
                              'Ví dụ:',
                              style: TextStyle(
                                fontSize: 16,
                                fontWeight: FontWeight.bold,
                                fontStyle: FontStyle.italic,
                              ),
                            ),
                            const SizedBox(height: 8),
                            Text(
                              currentCard.example,
                              style: const TextStyle(
                                fontSize: 16,
                                fontStyle: FontStyle.italic,
                              ),
                              textAlign: TextAlign.center,
                            ),
                          ],
                        ]
                      ],
                    ),
                  ),
                ),
              ),
            ),
          ),
          if (!_showAnswer)
            ElevatedButton(
              onPressed: _showAnswer,
              child: const Text('Hiển thị nghĩa'),
              style: ElevatedButton.styleFrom(
                padding: const EdgeInsets.symmetric(
                  horizontal: 32,
                  vertical: 16,
                ),
              ),
            )
          else
            Padding(
              padding: const EdgeInsets.symmetric(vertical: 16.0),
              child: Row(
                mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                children: [
                  ElevatedButton.icon(
                    onPressed: _markAsNotKnown,
                    icon: const Icon(Icons.close),
                    label: const Text('Chưa thuộc'),
                    style: ElevatedButton.styleFrom(
                      backgroundColor: Colors.red,
                      foregroundColor: Colors.white,
                      padding: const EdgeInsets.symmetric(
                        horizontal: 24,
                        vertical: 12,
                      ),
                    ),
                  ),
                  ElevatedButton.icon(
                    onPressed: _markAsKnown,
                    icon: const Icon(Icons.check),
                    label: const Text('Đã thuộc'),
                    style: ElevatedButton.styleFrom(
                      backgroundColor: Colors.green,
                      foregroundColor: Colors.white,
                      padding: const EdgeInsets.symmetric(
                        horizontal: 24,
                        vertical: 12,
                      ),
                    ),
                  ),
                ],
              ),
            ),
          const SizedBox(height: 16),
        ],
      ),
    );
  }
}