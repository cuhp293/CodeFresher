import 'dart:convert';
import 'package:shared_preferences/shared_preferences.dart';
import '../models/flashcard.dart';

class FlashcardStorage {
  static const String _key = 'flashcards';

  // Lưu danh sách flashcard vào bộ nhớ thiết bị
  static Future<void> saveFlashcards(List<Flashcard> flashcards) async {
    final prefs = await SharedPreferences.getInstance();
    final List<Map<String, dynamic>> flashcardMaps = flashcards.map((card) {
      return {
        'id': card.id,
        'word': card.word,
        'meaning': card.meaning,
        'example': card.example,
        'isMemorized': card.isMemorized,
      };
    }).toList();

    final String encodedData = jsonEncode(flashcardMaps);
    await prefs.setString(_key, encodedData);
  }

  // Đọc danh sách flashcard từ bộ nhớ thiết bị
  static Future<List<Flashcard>> loadFlashcards() async {
    final prefs = await SharedPreferences.getInstance();
    final String? flashcardsString = prefs.getString(_key);

    if (flashcardsString == null) {
      return [];
    }

    final List<dynamic> decodedData = jsonDecode(flashcardsString);
    return decodedData.map((data) {
      return Flashcard(
        id: data['id'],
        word: data['word'],
        meaning: data['meaning'],
        example: data['example'] ?? '',
        isMemorized: data['isMemorized'] ?? false,
      );
    }).toList();
  }
}