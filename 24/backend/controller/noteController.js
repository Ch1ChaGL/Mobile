const { Note } = require("../models/models");

class NoteController {
  async addNote(req, res, next) {
    const { NoteTitle, NoteData, NoteTime } = req.body;
    const data = await Note.create(req.body);
    res.json(data);
  }

  async getAllNote(req, res, next) {
    const data = await Note.getAll();
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
    res.json(data);
  }
}

module.exports = new NoteController();
