import 'package:flutter/material.dart';
import '../models/flashcard.dart';

class SearchScreen extends StatefulWidget {
  final List<Flashcard> flashcards;

  const SearchScreen({Key? key, required this.flashcards}) : super(key: key);

  @override
  _SearchScreenState createState() => _SearchScreenState();
}

class _SearchScreenState extends State<SearchScreen> {
  final TextEditingController _searchController = TextEditingController();
  List<Flashcard> _searchResults = [];

  @override
  void initState() {
    super.initState();
    _searchResults = widget.flashcards;
  }

  void _performSearch(String query) {
    setState(() {
      if (query.isEmpty) {
        _searchResults = widget.flashcards;
      } else {
        _searchResults = widget.flashcards
            .where((card) =>
        card.word.toLowerCase().contains(query.toLowerCase()) ||
            card.meaning.toLowerCase().contains(query.toLowerCase()))
            .toList();
      }
    });
  }

  @override
  void dispose() {
    _searchController.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Tìm kiếm từ vựng'),
      ),
      body: Column(
        children: [
          Padding(
            padding: const EdgeInsets.all(8.0),
            child: TextField(
              controller: _searchController,
              decoration: InputDecoration(
                labelText: 'Tìm kiếm',
                hintText: 'Nhập từ hoặc nghĩa',
                prefixIcon: const Icon(Icons.search),
                border: OutlineInputBorder(
                  borderRadius: BorderRadius.circular(10),
                ),
                suffixIcon: IconButton(
                  icon: const Icon(Icons.clear),
                  onPressed: () {
                    _searchController.clear();
                    _performSearch('');
                  },
                ),
              ),
              onChanged: _performSearch,
            ),
          ),
          Expanded(
            child: _searchResults.isEmpty
                ? const Center(
              child: Text(
                'Không tìm thấy kết quả',
                style: TextStyle(fontSize: 16),
              ),
            )
                : ListView.builder(
              itemCount: _searchResults.length,
              itemBuilder: (context, index) {
                final card = _searchResults[index];
                return Card(
                  margin: const EdgeInsets.symmetric(
                    vertical: 4,
                    horizontal: 8,
                  ),
                  child: ListTile(
                    title: Text(
                      card.word,
                      style: const TextStyle(fontWeight: FontWeight.bold),
                    ),
                    subtitle: Column(
                      crossAxisAlignment: CrossAxisAlignment.start,
                      children: [
                        Text(card.meaning),
                        if (card.example.isNotEmpty)
                          Padding(
                            padding: const EdgeInsets.only(top: 4),
                            child: Text(
                              'Ví dụ: ${card.example}',
                              style: const TextStyle(
                                fontStyle: FontStyle.italic,
                                fontSize: 12,
                              ),
                            ),
                          ),
                      ],
                    ),
                    trailing: Icon(
                      card.isMemorized
                          ? Icons.check_circle
                          : Icons.check_circle_outline,
                      color: card.isMemorized ? Colors.green : Colors.grey,
                    ),
                  ),
                );
              },
            ),
          ),
        ],
      ),
    );
  }
}