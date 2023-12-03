const { Note } = require("../models/models");

class NoteController {
  async addNote(req, res, next) {
    // Отбрасываем id из запроса, если он присутствует
    const { NoteID, ...restOfData } = req.body;

    console.log(restOfData);
    const data = await Note.create(restOfData);
    res.json(data);
  }

  async getAllNote(req, res, next) {
    const data = await Note.findAll();
    res.json(data);
  }
  async getNoteById(req, res, next) {
    const { id } = req.params;
    const data = await Note.findByPk(id);

    res.json(data);
  }

  async deleteNote(req, res, next) {
    const { id } = req.params;
    const data = await Note.destroy({ where: { NoteID: id } });
    res.json(data);
  }

  async updateNote(req, res, next) {
    const { NoteID } = req.body;
    const data = await Note.update(req.body, {
      where: {
        NoteID,
      },
    });
    console.log('--------------------------------');
    console.log(NoteID);
    console.log(data);
    console.log('--------------------------------');
    res.json(data);
  }
}

module.exports = new NoteController();
