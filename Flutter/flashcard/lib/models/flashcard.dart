class Flashcard {
  final String id;
  final String word;
  final String meaning;
  final String example;
  bool isMemorized;

  Flashcard({
    required this.id,
    required this.word,
    required this.meaning,
    this.example = '',
    this.isMemorized = false,
  });

  // Tạo một bản sao của flashcard với giá trị mới
  Flashcard copyWith({
    String? id,
    String? word,
    String? meaning,
    String? example,
    bool? isMemorized,
  }) {
    return Flashcard(
      id: id ?? this.id,
      word: word ?? this.word,
      meaning: meaning ?? this.meaning,
      example: example ?? this.example,
      isMemorized: isMemorized ?? this.isMemorized,
    );
  }
}